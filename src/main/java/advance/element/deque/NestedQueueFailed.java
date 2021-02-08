package advance.element.deque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class NestedQueueFailed {

	public static int solution(String S) {

		if (S == null || S.length() == 0) {
			return 1;
		}
		Deque<Character> deque = new LinkedList<Character>();

		for (int i = 0; i < S.length(); i++) {
			deque.add(S.charAt(i));
		}

		Iterator<Character> iterator = deque.iterator();

		while (iterator.hasNext()) {
			char head = deque.removeFirst();
			//System.out.println("\nhead removed---->" + head);

			if (!deque.isEmpty()) {
				switch (head) {
				case '(':
					if (!isTailValid(deque, ')'))
						return 0;
					break;
				case '[':
					if (!isTailValid(deque, ']'))
						return 0;
					break;
				case '{':
					if (!isTailValid(deque, '}'))
						return 0;
					break;
				default:
					break;
				}
			}

			//System.out.println("end of main loop deque  --->" + deque);
		} // end for

		//System.out.println("finish deque --->" + deque);
		isSpecialChar(deque);
		return 1;
	}

	private static boolean isSpecialChar(Deque<Character> deque) {
		boolean isSquare = deque.contains(')');
		boolean isBracket = deque.contains(']');
		boolean isCircle = deque.contains('}');
		if (isSquare || isBracket || isCircle) {
			return true;
		}

		return false;
	}

	private static boolean isSpecialChar(char c) {
		boolean isSquare = c == ')';
		boolean isBracket = c == ']';
		boolean isCircle = c == '}';
		if (isSquare || isBracket || isCircle) {
			return true;
		}

		return false;
	}

	private static boolean isTailValid(Deque<Character> deque, char filterTail) {
		//System.out.println("try to check tail of -->" + filterTail + " from " + deque.toString());

		char tail = deque.removeLast();
		// Iterator<Character> iterator = deque.iterator();

		//System.out.println("tail -->" + tail);

		if (tail == filterTail) {
			return true;
		} else {
			if (isSpecialChar(tail)) {
				return false;
			}
		}

		return false;
	}

	public static void main(String args[]) {
		String A = "([)()]";
		System.out.println(solution(A));

	}
}
