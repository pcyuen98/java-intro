package advance.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeywordAnalyzerMapReduce {

	 private static final int TOP_N = 10;

	    public Map<String, Long> getTopKeywords(String filePath, int topN) {
	        Path path = Paths.get(filePath);
	        validateFile(path);

	        long readStartTime = System.nanoTime();

	        Map<String, Long> keywordCounts;

	        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
	            ByteBuffer buffer = ByteBuffer.allocate(1024); // 64 KB buffer

	            // MAP PHASE: create list of partial keyword count maps
	            List<Map<String, Long>> partialResults = new ArrayList<>();

	            while (channel.read(buffer) > 0) {
	                buffer.flip();
	                String content = StandardCharsets.UTF_8.decode(buffer).toString();

	                Map<String, Long> partialMap = Arrays.stream(content.toLowerCase().split("[^a-z]+"))
	                        .filter(word -> !word.isEmpty())
	                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

	                partialResults.add(partialMap);
	                buffer.clear();
	            }

	            // REDUCE PHASE: merge all partial maps into final map
	            keywordCounts = partialResults.stream()
	                    .flatMap(map -> map.entrySet().stream())
	                    .collect(Collectors.toMap(
	                            Map.Entry::getKey,
	                            Map.Entry::getValue,
	                            Long::sum,              // Merge function for duplicate keys
	                            HashMap::new            // Use HashMap as the output container
	                    ));

	        } catch (IOException e) {
	            throw new RuntimeException("Error reading file with SeekableByteChannel: " + e.getMessage(), e);
	        }
	        long readEndTime = System.nanoTime();
	        System.out.printf("Time to read file using SeekableByteChannel: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

	        readStartTime = System.nanoTime();


	        Map<String, Long> sortedTopKeywords = keywordCounts.entrySet().stream()
	                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
	                .limit(topN)
	                .collect(Collectors.toMap(
	                        Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new
	                ));

	        readEndTime = System.nanoTime();
	        System.out.printf("Time to process and sort keywords (MapReduce style): %d ms%n", (readEndTime - readStartTime) / 1_000_000);

	        return sortedTopKeywords;
	    }

	    private void validateFile(Path path) {
	        if (!Files.exists(path) || !Files.isReadable(path)) {
	            throw new IllegalArgumentException("Invalid or unreadable file path: " + path);
	        }
	        if (!path.toString().toLowerCase().endsWith(".txt")) {
	            throw new IllegalArgumentException("Only .txt files are allowed. Provided: " + path);
	        }
	    }

	    public static void main(String[] args) {
	    	KeywordAnalyzerMapReduce analyzer = new KeywordAnalyzerMapReduce();

	        analyzeFile(analyzer, "fruits_100mb.txt");

	        System.out.println("Testing non-existent file:");
	        try {
	            analyzer.getTopKeywords("nonexistent.txt", TOP_N);
	        } catch (IllegalArgumentException e) {
	            System.err.println(e.getMessage());
	        }
	    }

	    private static void analyzeFile(KeywordAnalyzerMapReduce analyzer, String filePath) {
	        Runtime runtime = Runtime.getRuntime();
	        runtime.gc();

	        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

	        try {
	            Map<String, Long> result = analyzer.getTopKeywords(filePath, TOP_N);

	            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

	            System.out.println("Top " + TOP_N + " Keywords:");
	            result.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

	            System.out.printf("Memory Used: %.2f MB%n", (memoryAfter - memoryBefore) / 1024.0 / 1024.0);

	        } catch (IllegalArgumentException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
}
