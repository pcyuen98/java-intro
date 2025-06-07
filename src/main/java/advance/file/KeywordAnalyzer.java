package advance.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class KeywordAnalyzer {

    private static final int TOP_N = 10;

    public Map<String, Long> getTopKeywords(String filePath, int topN) {
        Path path = Paths.get(filePath);

        validateFile(path);

        long readStartTime = System.nanoTime(); // Start timing before reading

        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> keywordCounts = lines
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("[^a-z]+")))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            long readEndTime = System.nanoTime(); // End timing after collection

            System.out.printf("KeywordAnalyzer Time to read and process file: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

            readStartTime = System.nanoTime();
            Map<String, Long> hash =  keywordCounts.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(topN)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));
            readEndTime = System.nanoTime(); // End timing after collection
            System.out.printf("KeywordAnalyzer Time to sort: %d ms%n", (readEndTime - readStartTime) / 1_000_000);

            return hash;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage(), e);
        }
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
        KeywordAnalyzer analyzer = new KeywordAnalyzer();

        analyzeFile(analyzer, "fruits_100mb.txt");

        // Testing invalid path
        System.out.println("Testing non-existent file:");
        try {
            analyzer.getTopKeywords("nonexistent.txt", TOP_N);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void analyzeFile(KeywordAnalyzer analyzer, String filePath) {
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
