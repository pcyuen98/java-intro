package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/*Array Challenge
Have the function ArrayChallenge(strArr) read the array of strings stored in strArr, 


which will contain 2 elements: 
==============================
the first element will be a sequence of characters, 
and the second element will be a long string of comma-separated words, in alphabetical order, that represents a dictionary of some arbitrary length. 

For example: strArr can be: ["hellocat", "apple,bat,cat,goodbye,hello,yellow,why"]. 

Your goal is to determine if the first element in the input can be split into two words, 
where both words exist in the dictionary that is provided in the second input. In this example, 
the first element can be split into two words: hello and cat because both of those words are in the dictionary.

Your program should return the two words that exist in the dictionary separated by a comma. So for the example above, your program should return hello,cat. There will only be one correct way to split the first element of characters into two words. If there is no way to split string into two words that exist in the dictionary, return the string not possible. The first element itself will never exist in the dictionary as a real word.
Examples
Input: new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"}
Output: base,ball

Input: 

new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"}
Output: abcg,efd
*/
class StringArrayAndSortedMap {

	static List<String> outputArray = new ArrayList<String>();

	public static String ArrayChallenge(String[] strArr) {
		// code goes here

		// basic validation
		if (strArr == null || strArr.length < 2) {
			return "not possible";
		}
		
		try {

			String line1 = strArr[0];
			String line2 = strArr[1];

			if (line1.length() == 0 || line2.length() == 0) {
				return "not possible";
			}

			String[] list2Array = line2.split(",");
			
			// while loop to find word by word
			while (line1.length() > 0) {

				String wordMatched = getMostMatchingWord(line1, list2Array);

				outputArray.add(wordMatched);

				// find the next words
				line1 = line1.substring(wordMatched.length(), line1.length());

				// System.out.println("after line1-->" + line1);
			}
		} catch (Exception e) {
			System.out.println(e);

		}

		//System.out.println("outputArray-->" + outputArray);

		if (!outputArray.isEmpty()) {
			String separatedStr = String.join(",", outputArray);

			// System.out.println("separatedStr----->" + listOne);
			return separatedStr;
		} else {
			return "not possible";
		}

	}

	// line1 - first string element input
	// listTwo - 2nd elements of the input 
	public static String getMostMatchingWord(String line1, String[] list2Array) {
		
		// changed to NavigableMap so can do reverse Map. Code readability 
		NavigableMap<String, Integer> sm = new TreeMap<String, Integer>();
		System.out.println("\ngetValue started -->" + line1);
		
		System.out.println("list2Array-->" + list2Array);
		
		// find matching key words between the 2 elements and insert into the map
		for (String s : list2Array) {
			// System.out.println("s-->" + s);
			int iMatch = line1.indexOf(s);

			String strMatchingFirstWord = "";
			try {
				strMatchingFirstWord = line1.substring(0, s.length());
			} catch (Exception e) {

			}

			boolean isMatchingWord = strMatchingFirstWord.equals(s);
			if (iMatch > -1 && isMatchingWord) {
				//System.out.println("Match-->" + s);

				sm.put(s, s.length());
			}
		}

		//System.out.println("outputList--->" + outputArray);
		//System.out.println("sm--->" + sm);
		
		// do a revert sort so can find the most matching words at the first list
		// i.e {b=1, bas=3, base=4} base is suppose the matching word
		sm = sm.descendingMap();

		System.out.println("reverse sort--->" + sm);

		String firstKey = sm.keySet().stream().findFirst().get();
		
		//System.out.println("getValue ends firstKey--->" + firstKey);
		
		// return the most matching word
		return firstKey;
	}

	public static void main(String[] args) {
		//  Scanner s = new Scanner(System.in);
		String[] strArr = new String[] { "baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z" };

		String str = ArrayChallenge(strArr);

		System.out.println("str-->" + str);
		// TODO Auto-generated method stub

	}

}
