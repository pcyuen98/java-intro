package advance.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountNIOvsStream {

    private static final int TOP_N = 10;

    public static void main(String[] args) {
        WordCountNIOvsStream analyzer = new WordCountNIOvsStream();
        String filePath = "fruits_100mb.txt";

        // Choose the method you want to run (Execute either one first for more accurate result) : 
        executeAnalysis("NIO", filePath, analyzer::getTopKeywordsByNIO);
        //executeAnalysis("Stream", filePath, analyzer::getTopKeywordsByStream);
    }

    private static void executeAnalysis(String methodName, String filePath, Function<String, Map<String, Long>> strategy) {
        Runtime runtime = Runtime.getRuntime();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        try {
            Map<String, Long> topKeywords = strategy.apply(filePath);
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            System.out.printf("[%s] Top %d Keywords:%n", methodName, TOP_N);
            topKeywords.forEach((word, count) -> System.out.printf("%s: %d%n", word, count));

            System.out.printf("[%s] Memory Used: %.2f MB%n%n", methodName, (memoryAfter - memoryBefore) / 1024.0 / 1024.0);
        } catch (Exception e) {
            System.err.printf("[%s] Error: %s%n", methodName, e.getMessage());
        }
    }

    public Map<String, Long> getTopKeywordsByNIO(String filePath) {
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
                String content = tail + StandardCharsets.UTF_8.decode(buffer).toString();

                String[] parts = extractBeforeAndAfterLastFullStop(content);

                if (!parts[0].isEmpty()) {
                    paragraph.append(parts[0]);
                    tail.setLength(0);
                    tail.append(parts[1]);

                    countKeywords(paragraph.toString(), keywordCounts);
                    paragraph.setLength(0);
                } else {
                    paragraph.append(content);
                    tail.setLength(0);
                }

                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file with SeekableByteChannel", e);
        }

        System.out.printf("getTopKeywordsByNIO Read Time: %d ms%n", elapsedMillis(readStartTime));
        return sortTopKeywords(keywordCounts);
    }

    public Map<String, Long> getTopKeywordsByStream(String filePath) {
        Path path = Paths.get(filePath);
        validateFile(path);

        long start = System.nanoTime();

        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> counts = lines
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("[^a-z]+")))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            System.out.printf("getTopKeywordsByStream Read + Process Time: %d ms%n", elapsedMillis(start));
            return sortTopKeywords(counts);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file with Stream", e);
        }
    }

    private void countKeywords(String text, Map<String, Long> keywordCounts) {
        Arrays.stream(text.toLowerCase().split("[^a-z]+"))
                .filter(word -> !word.isEmpty())
                .forEach(word -> keywordCounts.merge(word, 1L, Long::sum));
    }

    private Map<String, Long> sortTopKeywords(Map<String, Long> keywordCounts) {
        long start = System.nanoTime();

        Map<String, Long> sorted = keywordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_N)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.printf("Sort Time: %d ms%n", elapsedMillis(start));
        return sorted;
    }

    private long elapsedMillis(long startNano) {
        return (System.nanoTime() - startNano) / 1_000_000;
    }

    private void validateFile(Path path) {
        if (!Files.exists(path) || !Files.isReadable(path)) {
            throw new IllegalArgumentException("Invalid or unreadable file path: " + path);
        }
        if (!path.toString().toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("Only .txt files are allowed. Provided: " + path);
        }
    }

    public static String[] extractBeforeAndAfterLastFullStop(String text) {
        int lastDotIndex = text.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return new String[]{"", ""};
        }
        return new String[]{
                text.substring(0, lastDotIndex + 1),
                text.substring(lastDotIndex + 1)
        };
    }
}
