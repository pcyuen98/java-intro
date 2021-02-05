package advance;

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
public class ArrayDequeBasicInvalid {

	public static boolean isSymbolExisted(String S) {
		boolean isBracket = S.indexOf('(') > -1;
		boolean isCurly = S.indexOf('{') > -1;
		boolean isSquare = S.indexOf('[') > -1;

		if (isBracket || isCurly || isSquare) {
			return true;
		}

		return false;
	}

	public static int solution(String S) {

		while (isSymbolExisted(S)) {
			//System.out.println("isSymbolExisted(S) ==>" + isSymbolExisted(S));
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				switch (c) {

				case '{':
					//System.out.println("case { ==>");
					S = recursiveLoop(S, '{', '}');
					break;
				case '[':
					//System.out.println("case [ ==>");
					S = recursiveLoop(S, '[', ']');
					break;
				case '(':
					//System.out.println("case ( ==>");
					S = recursiveLoop(S, '(', ')');
					break;
				default:
				//	System.out.println("Nothing found ==>" + c);
				}

				//System.out.println("processed S ==>" + S);
				if (S == null) {
					return 0;
				}

			} // end for

		} // end while

		return 1;
	}

	private static String recursiveLoop(String s, char filterHead, char filterTail) {

		int indexHead = s.indexOf(filterHead);
		s = s.substring(indexHead + 1);
		//StringBuilder sb = new StringBuilder(s);
		//System.out.println("new s :" + s);

		//System.out.println("s.charAt(0)--> :" + s.charAt(0));
		if (s.charAt(0) == filterTail) {
			//System.out.println("tail found at 1st character :" + s);
			return s.substring(1, s.length());
		}
		
		for (int i = 1; i < s.length(); i++) {

			char c = s.charAt(s.length() - i);
			//System.out.println("c :  " + c);
			if (c == filterTail) {

				//sb.deleteCharAt(s.length() - i);
				s  = s.substring(0, s.length() - i) + s.substring(s.length() - i);
				//System.out.println("match -->" + sb);
				return s;
			}
		}

		return null;
	}

	
	public static void main(String args[]) {
		String s = "{-------------------}";
		long before = System.currentTimeMillis();
		
		for (int i =0; i < 1000000; i++) {
			System.out.println("result--" + solution(s));
		}
	
		
		long after = System.currentTimeMillis();
		System.out.println("Total Time Taken--" + (after - before));
		// recursiveLoop(s, '{', '}');
	}
}
