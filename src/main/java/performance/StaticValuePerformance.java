package performance;

import java.util.ArrayList;

import util.BytesToMegabytes;

public class StaticValuePerformance {

	static ArrayList<Integer> staticList = new ArrayList<>();

	public static void main(String[] args) {

		StaticVsNonStaticMemory demo = new StaticVsNonStaticMemory();

		long startTime = System.currentTimeMillis();
		long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		for (int i = 0; i < 100_000_000; i++) {
			staticList.add(i);
		}

		staticList.clear();
		Runtime.getRuntime().gc();

		long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println(
				"Static List Memory Usage (bytes): " + BytesToMegabytes.bytesToMegabytes(afterMemory - beforeMemory));
		System.out.println("Static List Time (ms): " + (System.currentTimeMillis() - startTime));

	}
}
