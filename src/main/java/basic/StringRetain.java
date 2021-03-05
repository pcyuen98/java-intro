package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringRetain {

	public static String FindIntersection(String[] strArr) {
		try {
			String list1 = strArr[0];
			String[] list1Array = list1.split(", ");

			String list2 = strArr[1];
			String[] list2Array = list2.split(", ");

			Collection<String> listOne = new ArrayList<String>(Arrays.asList(list1Array));

			Collection<String> listTwo = new ArrayList<String>(Arrays.asList(list2Array));

			listOne.retainAll(listTwo);
			// System.out.println("listOne----->" + listOne);

			if (!listOne.isEmpty()) {
				String separatedStr = String.join(",", listOne);

				// System.out.println("separatedStr----->" + listOne);
				return separatedStr;
			} else {
				return "false";
			}

		} catch (Exception e) {
			return "false";
		}

	}

	public static void main(String[] args) {

		String[] strArr = new String[] { "11, 12, 14, 16, 20", "11, 12, 13, 18, 21" };

		System.out.println("strArr--->" + FindIntersection(strArr));

	}
}
