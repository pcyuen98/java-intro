package advance.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class KeywordAnalyzerNIO {

    private static final int TOP_N = 10;

    public Map<String, Long> getTopKeywords(String filePath, int topN) {
        Path path = Paths.get(filePath);
        validateFile(path);

        long readStartTime = System.nanoTime();

        // Read file content using SeekableByteChannel
        StringBuilder contentBuilder = new StringBuilder();

        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(16 * 1024); // 16 KB buffer
            while (channel.read(buffer) > 0) {
                buffer.flip();
                contentBuilder.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file with SeekableByteChannel: " + e.getMessage(), e);
        }

        long readEndTime = System.nanoTime();
        System.out.printf("Time to read file using SeekableByteChannel: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

        readStartTime = System.nanoTime();

        Map<String, Long> keywordCounts = Arrays.stream(contentBuilder.toString().toLowerCase().split("[^a-z]+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

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
        System.out.printf("Time to process and sort keywords: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

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
    	KeywordAnalyzerNIO analyzer = new KeywordAnalyzerNIO();

        analyzeFile(analyzer, "fruits_100mb.txt");

        // Testing invalid path
        System.out.println("Testing non-existent file:");
        try {
            analyzer.getTopKeywords("nonexistent.txt", TOP_N);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void analyzeFile(KeywordAnalyzerNIO analyzer, String filePath) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Clean up memory for accurate measurement

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
