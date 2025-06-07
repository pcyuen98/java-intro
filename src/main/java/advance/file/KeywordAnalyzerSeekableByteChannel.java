package advance.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KeywordAnalyzerSeekableByteChannel {

    private static final int TOP_N = 10;

    public static String[] extractBeforeAndAfterLastFullStop(String text) {
        int lastDotIndex = text.lastIndexOf('.');
        
        if (lastDotIndex == -1) {
            return new String[]{"", ""}; // No full stop found
        }

        return new String[]{
            text.substring(0, lastDotIndex + 1),
            text.substring(lastDotIndex + 1)
        };
    }
    
    public Map<String, Long> getTopKeywords(String filePath, int topN) {
        Path path = Paths.get(filePath);
        validateFile(path);

        long readStartTime = System.nanoTime();

        Map<String, Long> keywordCounts = new HashMap<>();
        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
            StringBuilder tail = new StringBuilder();
            StringBuilder paragraph = new StringBuilder();

            while (channel.read(buffer) > 0) {
                buffer.flip();
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                content = tail.toString() + content;

                String[] str = extractBeforeAndAfterLastFullStop(content);

                if (!str[0].isEmpty()) {
                    paragraph.append(str[0]);
                    tail.setLength(0);
                    tail.append(str[1]);

                    Map<String, Long> additionalKeywordCounts =
                            Arrays.stream(paragraph.toString().toLowerCase().split("[^a-z]+"))
                                    .filter(word -> !word.isEmpty())
                                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

                    for (Map.Entry<String, Long> entry : additionalKeywordCounts.entrySet()) {
                        keywordCounts.merge(entry.getKey(), entry.getValue(), Long::sum);
                    }

                    paragraph.setLength(0); // clear paragraph buffer
                } else {
                    paragraph.append(content);
                    tail.setLength(0);
                }

                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file with SeekableByteChannel: " + e.getMessage(), e);
        }

        long readEndTime = System.nanoTime();
        System.out.printf("KeywordAnalyzerSeekableByteChannel Time to read file using SeekableByteChannel: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

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
        System.out.printf("KeywordAnalyzerSeekableByteChannel Time to process and sort keywords (MapReduce style): %d ms%n", (readEndTime - readStartTime) / 1_000_000);

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
    	KeywordAnalyzerSeekableByteChannel analyzer = new KeywordAnalyzerSeekableByteChannel();

        analyzeFile(analyzer, "fruits_100mb.txt");

    }

    private static void analyzeFile(KeywordAnalyzerSeekableByteChannel analyzer, String filePath) {
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
