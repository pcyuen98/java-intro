package advance.element.deque;

import java.util.*;

public class DequeOnSymbols {
    private static final Map<Character, Character> BRACKETS = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        public static int solution(String S) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : S.toCharArray()) {
                if (BRACKETS.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() != BRACKETS.get(c)) {
                        return 0;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }

    public static void main(String[] args) {
        System.out.println(solution("({}{})"));  // Output: 1
    }
}