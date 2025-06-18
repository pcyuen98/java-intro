package advance.element.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleNestedQueue {

	public static int solution(String S) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			System.out.println("\nc---->" + c);
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
		String A = "{U}";
		System.out.println(solution(A));

	}
}
