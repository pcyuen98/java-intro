package advance.element.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListAndStack {

	public static int[] solution(int[] A, int iRotate) {
		Stack<Integer> stack = new Stack<Integer>();

		List<Integer> rotateList = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			stack.push(A[i]);
		}

		System.out.println("stack --->" + stack);

		for (int i = 0; i <= iRotate - 1; i++) {
			int pop = (int) stack.pop();
			rotateList.add(pop);
			System.out.println("pop --->" + pop);
		}
		
		for (int i : stack) {
			rotateList.add(i);
			System.out.println("remain --->" + i);
		}

		return rotateList.stream().mapToInt(i->i).toArray();
	}

	public static void main(String args[]) {

		int[] A = { 3, 8, 9, 7, 6 };
		int[] output =solution(A, 3);
		
		for (int i : output) {
			System.out.print(i + ",");
		}
	}
}
