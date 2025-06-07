package advance.file;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class KeywordAnalyzerQueue {

    private static final int TOP_N = 10;
    private static final int NUM_WORKERS = 10;
    private static final String END_OF_FILE = "__END__";

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

        long startTime = System.nanoTime();

        ConcurrentLinkedQueue<String> paragraphQueue = new ConcurrentLinkedQueue<>();
        List<Future<Map<String, Long>>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);

        // Start worker threads
        for (int i = 0; i < NUM_WORKERS; i++) {
            futures.add(executor.submit(() -> {
            	long readEndTime = System.nanoTime();
                Map<String, Long> localCounts = new HashMap<>();
                while (true) {
                    String paragraph = paragraphQueue.poll();
                    if (paragraph == null) {
                        Thread.sleep(1); // Wait for new data
                        continue;
                    }
                    if (END_OF_FILE.equals(paragraph)) break;

                    Map<String, Long> count = Arrays.stream(paragraph.toLowerCase().split("[^a-z]+"))
                            .filter(word -> !word.isEmpty())
                            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

                    count.forEach((k, v) -> localCounts.merge(k, v, Long::sum));
                }
                System.out.printf("Worker" + Thread.currentThread().getId() + " Time to dequeue: %d ms%n", (readEndTime - startTime) / 1_000_000);
                return localCounts;
            }));
        }

        // File reading logic
        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
            StringBuilder tail = new StringBuilder();
            StringBuilder paragraph = new StringBuilder();

            while (channel.read(buffer) > 0) {
                buffer.flip();
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                content = tail + content;

                String[] str = extractBeforeAndAfterLastFullStop(content);
                if (!str[0].isEmpty()) {
                    paragraph.append(str[0]);
                    paragraphQueue.offer(paragraph.toString());
                    paragraph.setLength(0);
                    tail.setLength(0);
                    tail.append(str[1]);
                } else {
                    paragraph.append(content);
                    tail.setLength(0);
                }

                buffer.clear();
            }

            // Add remaining paragraph (if any)
            if (paragraph.length() > 0) {
                paragraphQueue.offer(paragraph.toString());
            }

            // Add poison pills
            for (int i = 0; i < NUM_WORKERS; i++) {
                paragraphQueue.offer(END_OF_FILE);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file with SeekableByteChannel", e);
        }

        long readEndTime = System.nanoTime();
        System.out.printf("Time to read and enqueue: %d ms%n", (readEndTime - startTime) / 1_000_000);

        // Merge results from workers
        Map<String, Long> finalCounts = new HashMap<>();
        for (Future<Map<String, Long>> future : futures) {
            try {
                Map<String, Long> workerResult = future.get();
                workerResult.forEach((k, v) -> finalCounts.merge(k, v, Long::sum));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error collecting worker results", e);
            }
        }

        executor.shutdown();

        long sortStartTime = System.nanoTime();

        Map<String, Long> sortedTopKeywords = finalCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        long sortEndTime = System.nanoTime();
        System.out.printf("Time to process and sort keywords: %d ms%n", (sortEndTime - sortStartTime) / 1_000_000);

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
    	KeywordAnalyzerQueue analyzer = new KeywordAnalyzerQueue();
        analyzeFile(analyzer, "fruits_100mb.txt");
    }

    private static void analyzeFile(KeywordAnalyzerQueue analyzer, String filePath) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        try {
            long sortStartTime = System.nanoTime();


            Map<String, Long> result = analyzer.getTopKeywords(filePath, TOP_N);

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("Top " + TOP_N + " Keywords:");
            result.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

            System.out.printf("All processes TimeTaken: %d ms%n", (System.nanoTime() - sortStartTime) / 1_000_000);

            System.out.printf("Memory Used: %.2f MB%n", (memoryAfter - memoryBefore) / 1024.0 / 1024.0);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
