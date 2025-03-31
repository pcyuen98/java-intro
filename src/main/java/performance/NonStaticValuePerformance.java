package performance;

import java.util.ArrayList;

import util.BytesToMegabytes;

public class NonStaticValuePerformance {

	ArrayList<Integer> nonStaticList = new ArrayList<>();
	
	public static void main(String[] args) {

		NonStaticValuePerformance demo = new NonStaticValuePerformance();

		long startTime = System.currentTimeMillis();
		long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		for (int i = 0; i < 100_000_000; i++) {
			demo.nonStaticList.add(i);
		}

		demo.nonStaticList.clear();
		Runtime.getRuntime().gc();

		long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println(
				"Non Static List Memory Usage (bytes): " + BytesToMegabytes.bytesToMegabytes(afterMemory - beforeMemory));
		System.out.println("Non Static List Time (ms): " + (System.currentTimeMillis() - startTime));

	}
    
}
