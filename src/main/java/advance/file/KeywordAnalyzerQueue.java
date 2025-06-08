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
    private static final int NUM_WORKERS = 15;
    private static final String END_OF_FILE = "__END__";

    private final ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);

    public static void main(String[] args) {
        KeywordAnalyzerQueue analyzer = new KeywordAnalyzerQueue();
        analyzer.analyzeFile("giant_file1gb.txt");
    }

    public void analyzeFile(String filePath) {
        Runtime runtime = Runtime.getRuntime();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long totalStartTime = System.nanoTime();

        try {
            Path path = Paths.get(filePath);
            validateFile(path);
            Map<String, Long> result = getTopKeywordsQueue(path, TOP_N);
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("Top " + TOP_N + " Keywords:");
            result.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

            System.out.printf("KeywordAnalyzerQueue Total Time Taken: %d ms%n", (System.nanoTime() - totalStartTime) / 1_000_000);
            System.out.printf("[Queue] Memory Used: %.2f MB%n", (memoryAfter - memoryBefore) / 1024.0 / 1024.0);

        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    public Map<String, Long> getTopKeywordsQueue(Path path, int topN) {

        ConcurrentLinkedQueue<String> paragraphQueue = new ConcurrentLinkedQueue<>();
        List<Future<Map<String, Long>>> futures = startWorkerThreads(paragraphQueue);

        long readStart = System.nanoTime();
        readFileToQueue(path, paragraphQueue);
        long readEnd = System.nanoTime();
        System.out.printf("getTopKeywordsQueue Time to read and enqueue: %d ms%n", (readEnd - readStart) / 1_000_000);

        return mergeWorkerResults(futures, topN);
    }

    private List<Future<Map<String, Long>>> startWorkerThreads(Queue<String> paragraphQueue) {
        List<Future<Map<String, Long>>> futures = new ArrayList<>();
        for (int i = 0; i < NUM_WORKERS; i++) {
            futures.add(executor.submit(() -> {
                Map<String, Long> localCounts = new HashMap<>();
                while (true) {
                    String paragraph = paragraphQueue.poll();
                    if (paragraph == null) {
                        Thread.sleep(1); // Wait for more data
                        continue;
                    }
                    if (END_OF_FILE.equals(paragraph)) break;

                    Arrays.stream(paragraph.toLowerCase().split("[^a-z]+"))
                          .filter(word -> !word.isEmpty())
                          .forEach(word -> localCounts.merge(word, 1L, Long::sum));
                }
                return localCounts;
            }));
        }
        return futures;
    }

    private void readFileToQueue(Path path, Queue<String> paragraphQueue) {
        try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
            StringBuilder tail = new StringBuilder();
            StringBuilder paragraph = new StringBuilder();

            while (channel.read(buffer) > 0) {
                buffer.flip();
                String content = tail + StandardCharsets.UTF_8.decode(buffer).toString();
                buffer.clear();

                String[] parts = extractBeforeAndAfterLastFullStop(content);
                if (!parts[0].isEmpty()) {
                    paragraph.append(parts[0]);
                    paragraphQueue.offer(paragraph.toString());
                    paragraph.setLength(0);
                    tail.setLength(0);
                    tail.append(parts[1]);
                } else {
                    paragraph.append(content);
                    tail.setLength(0);
                }
            }

            if (paragraph.length() > 0) {
                paragraphQueue.offer(paragraph.toString());
            }

            for (int i = 0; i < NUM_WORKERS; i++) {
                paragraphQueue.offer(END_OF_FILE);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    private Map<String, Long> mergeWorkerResults(List<Future<Map<String, Long>>> futures, int topN) {
        Map<String, Long> mergedCounts = new HashMap<>();

        for (Future<Map<String, Long>> future : futures) {
            try {
                future.get().forEach((k, v) -> mergedCounts.merge(k, v, Long::sum));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error in worker thread", e);
            }
        }

        long sortStart = System.nanoTime();
        Map<String, Long> topKeywords = mergedCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        long sortEnd = System.nanoTime();
        System.out.printf("Time to process and sort keywords: %d ms%n", (sortEnd - sortStart) / 1_000_000);

        return topKeywords;
    }

    private static String[] extractBeforeAndAfterLastFullStop(String text) {
        int lastDotIndex = text.lastIndexOf('.');
        return lastDotIndex == -1
                ? new String[]{"", ""}
                : new String[]{
                    text.substring(0, lastDotIndex + 1),
                    text.substring(lastDotIndex + 1)
                };
    }

    private void validateFile(Path path) {
        if (!Files.exists(path) || !Files.isReadable(path)) {
            throw new IllegalArgumentException("File does not exist or is not readable: " + path);
        }
        if (!path.toString().toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("Only .txt files are allowed: " + path);
        }
    }
}
