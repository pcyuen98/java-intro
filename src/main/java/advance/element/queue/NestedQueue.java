package advance.element.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class NestedQueue {

	public static int solution(String S) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			System.out.println("c---->" + c);
			System.out.println("stack---->" + stack);
			switch (c) {
			case ')':
				if (stack.isEmpty() || stack.pop() != '(')
					return 0;
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[')
					return 0;
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{')
					return 0;
				break;
			default:
				stack.push(c);
				break;
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String args[]) {
		String A = "({}{})";
		System.out.println(solution(A));

	}
}
