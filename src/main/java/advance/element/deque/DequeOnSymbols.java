package advance.element.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOnSymbols {

	public static int solution(String S) {
		Deque<Character> deque = new ArrayDeque<Character>();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			System.out.println("c---->" + c);
			System.out.println("stack---->" + deque);
			switch (c) {
			case ')':
				if (deque.isEmpty() || deque.pop() != '(')
					return 0;
				break;
			case ']':
				if (deque.isEmpty() || deque.pop() != '[')
					return 0;
				break;
			case '}':
				if (deque.isEmpty() || deque.pop() != '{')
					return 0;
				break;
			default:
				deque.push(c);
				break;
			}
		}

		return deque.isEmpty() ? 1 : 0;
	}
	
	public static void main(String args[]) {
		String A = "({}{})";
		System.out.println(solution(A));

	}
}
