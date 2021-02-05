package advance;

import java.util.ArrayDeque;
import java.util.Deque;

/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".*/

// https://stackoverflow.com/questions/28951336/codility-brackets-determine-whether-a-given-string-of-parentheses-is-properly
public class StackBasic {

	public static int solution(String S) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < S.length(); i++) {
        	

            char c = S.charAt(i);

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
                    if(stack.isEmpty() || stack.pop() != '{')
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
		String s = "{-----}";
		System.out.println("result--" + solution(s));
		
	}
}
