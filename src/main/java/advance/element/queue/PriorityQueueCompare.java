package advance.element.queue;

import java.util.PriorityQueue;
import java.util.Comparator;

class PriorityQueueCompare {
	public static void main(String[] args) {

		// Creating a priority queue
		PriorityQueue<Integer> numbers = new PriorityQueue<>(new CustomComparator());
		numbers.add(0);
		numbers.add(4);
		numbers.add(1);
		numbers.add(3);
		System.out.print("PriorityQueue: " + numbers);
	}
}

class CustomComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer number1, Integer number2) {
		
		System.out.println("\n--->number1: " + number1);
		System.out.println("--->number2: " + number2);
		int value = number1.compareTo(number2);
		// elements are sorted in reverse order
		if (value > 0) {
			return -1;
		} else if (value < 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
