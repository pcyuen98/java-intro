package advance.element.deque;

import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue {
	public static void main(String args[]) {
		Queue<String> queue = new LinkedList<>();
		
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());
		System.out.println("iterating the queue elements:");
		
		queue.forEach(System.out::println);
		
		queue.remove();
		queue.poll();
		
		System.out.println("after removing two elements:");
		queue.forEach(System.out::println);
	}
}
