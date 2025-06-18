package advance.file;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class KeywordWorkerManager {

	private final int numWorkers;
	private final ExecutorService executor;

	public static final String END_OF_FILE = "__END__";

	public KeywordWorkerManager(int numWorkers) {
		this.numWorkers = numWorkers;
		this.executor = Executors.newFixedThreadPool(numWorkers);
	}

	public List<Future<Map<String, Long>>> startWorkerThreads(Queue<String> paragraphQueue) {
		List<Future<Map<String, Long>>> futures = new ArrayList<>();

		for (int i = 0; i < numWorkers; i++) {
			int workerId = i + 1; // Optional: use for logging
			futures.add(executor.submit(() -> {
				long startTime = System.nanoTime();

				Map<String, Long> localCounts = new HashMap<>();
				while (true) {
					String paragraph = paragraphQueue.poll();
					if (paragraph == null) {
						Thread.sleep(1);
						continue;
					}
					if (KeywordWorkerManager.END_OF_FILE.equals(paragraph))
						break;

					Arrays.stream(paragraph.toLowerCase().split("[^a-z]+")).filter(word -> !word.isEmpty())
							.forEach(word -> localCounts.merge(word, 1L, Long::sum));
				}

				long endTime = System.nanoTime();
				long durationMs = (endTime - startTime) / 1_000_000;

				System.out.printf("Worker-%d finished in %d ms%n", workerId, durationMs);

				return localCounts;
			}));
		}

		return futures;
	}

	public Map<String, Long> mergeWorkerResults(List<Future<Map<String, Long>>> futures, int topN)
			throws InterruptedException, ExecutionException {
		Map<String, Long> mergedCounts = new HashMap<>();

		for (Future<Map<String, Long>> future : futures) {
			future.get().forEach((k, v) -> mergedCounts.merge(k, v, Long::sum));
		}

		return mergedCounts.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.limit(topN)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
	}

	public void shutdown() {
		executor.shutdown();
	}
}
