package advance;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DeQueBasic {

	public static int solution(String S) {

		Deque<Character> deque = new LinkedList<Character>();

		for (int i = 0; i < S.length(); i++) {
			deque.add(S.charAt(i));
		}

		Iterator<Character> iterator = deque.iterator();

		while (iterator.hasNext()) {
			char head = deque.removeFirst();
			System.out.println("head removed:" + head);

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

			System.out.println("deque:" + deque);
		} // end for

		return 1;
	}

	public static void main(String args[]) {
		String A = "([ )()]";
		System.out.println(solution(A));

	}

	private static boolean isTailValid(Deque<Character> deque, char filterTail) {
		System.out.println("try to check tail of :" + filterTail + " from " + deque.toString());
		Iterator<Character> iterator = deque.iterator();

		while (iterator.hasNext()) {
			char tail = iterator.next();
			if (tail == filterTail) {
				return true;
			}
		}

		return false;
	}
}
