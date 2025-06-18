package advance.element.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class ListAndStack {

	public static int[] solution(int[] intList, int iRotate) {
		Deque<Integer> stack = new ArrayDeque<>();

		List<Integer> rotateList = new ArrayList<>();
		rotateList.forEach(stack::push);

		IntStream.range(0, iRotate).forEach(i -> {
		    int pop = stack.pop();
		    rotateList.add(pop);
		    System.out.println("pop ---> " + pop);
		});
		
		for (int i : stack) {
			rotateList.add(i);
			System.out.println("remain --->" + i);
		}

		return rotateList.stream().mapToInt(i->i).toArray();
	}

	public static void main(String args[]) {

		int[] intList = { 3, 8, 9, 7, 6 };
		int[] output =solution(intList, 3);
		
		for (int i : output) {
			System.out.print(i + ",");
		}
	}
}
