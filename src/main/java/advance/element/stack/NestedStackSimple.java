package advance.element.stack;

import java.util.Stack;

public class NestedStackSimple {

	public static int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		if (null == S) {
			return 0;
		} else if (S.isEmpty()) {
			return 1;
		}
		for (Character C : S.toCharArray()) {
			System.out.println("\nC-->" + C);
			switch (C) {
			case ')':
				pops(stack, '(');
				break;
			case '}':
				pops(stack, '{');
				break;
			case ']':
				pops(stack, '[');
				break;

			default:
				stack.push(C);
				System.out.println("stack-->" + stack);
				break;
			}

		}
		return stack.isEmpty() ? 1 : 0;
	}

	private static void pops(Stack<Character> s, Character C) {

		System.out.println("\nstart stack before pop-->" + s  + " C-->" + C );
		while (!s.isEmpty() && s.peek() != C) {
			char peek = s.peek();
			char popC = s.pop();
			
			System.out.println("pop C Loop-->" + popC + "  peek-->" + peek);
		}
		if (!s.isEmpty()) {
			char popC = s.pop();

			System.out.println("pop C-->" + popC);
		} else {
			s.push(C);
		}

		System.out.println("ending stack after pop-->" + s);
	}

	public static void main(String args[]) {
		String s = "{abcd]123]}";

		System.out.println("result-->" + solution(s));

		// recursiveLoop(s, '{', '}');
	}
}
