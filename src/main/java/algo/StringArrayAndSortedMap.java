package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

class StringArrayAndSortedMap {

	static List<String> outputArray = new ArrayList<String>();

	public static String ArrayChallenge(String[] strArr) {
		// code goes here

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
			Collection<String> listTwo = new ArrayList<String>(Arrays.asList(list2Array));
			while (line1.length() > 0) {
				// System.out.println("before line1-->" + line1);
				String firstValue = getValue(line1, listTwo, list2Array);

				outputArray.add(firstValue);

				line1 = line1.substring(firstValue.length(), line1.length());

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

	public static String getValue(String line1, Collection<String> listTwo, String[] list2Array) {
		SortedMap<String, Integer> sm = new TreeMap<String, Integer>();
		for (String s : list2Array) {
			// System.out.println("s-->" + s);
			int iMatch = line1.indexOf(s);

			String strMatchingFirstWord = "";
			try {
				strMatchingFirstWord = line1.substring(0, s.length());
			} catch (Exception e) {

			}

			// System.out.println("strMatchingFirstWord-->" + strMatchingFirstWord);
			// System.out.println("strMatchingFirstWord-->" + strMatchingFirstWord);

			boolean isMatchingWord = strMatchingFirstWord.equals(s);
			if (iMatch > -1 && isMatchingWord) {
				// System.out.println("Match-->" + s);

				sm.put(s, s.length());
			}
		}

		// System.out.println("outputList--->" + outputArray);

		Map<String, Integer> sortedMapReverseOrder = sm.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// System.out.println("sorted--->" + sortedMapReverseOrder);

		String firstKey = sortedMapReverseOrder.keySet().stream().findFirst().get();
		// System.out.println("firstKey--->" + firstKey);

		return firstKey;
	}

	public static void main(String[] args) {
		//  Scanner s = new Scanner(System.in);
		String[] strArr = new String[] { "abcgefd", "abc,fd" };

		String str = ArrayChallenge(strArr);

		System.out.println("str-->" + str);
		// TODO Auto-generated method stub

	}

}
