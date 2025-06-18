package advance.element.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class BasicPriorityQueue {
	public static void main(String args[]) {
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.add("Amit");
		queue.add("Vijay");
		queue.add("Karan");
		queue.add("Jai");
		queue.add("Rahul");
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());

		System.out.println("iterating the queue elements:");

		queue.forEach(System.out::println);

		queue.remove();
		queue.poll();

		System.out.println("after removing two elements:");
		Iterator<String> itr2 = queue.iterator();
		itr2.forEachRemaining(itr -> System.out.println("itr->" + itr));

		// converting into arrayList
		List<String> list = new ArrayList<>(queue);
		IntStream.range(0, list.size()).forEach(i -> System.out.println("Index: " + i + ", Item: " + list.get(i)));
	}

}
