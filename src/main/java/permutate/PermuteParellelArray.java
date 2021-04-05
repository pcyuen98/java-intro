package permutate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*Have the function ArrayChallenge(arr) take the array of integers stored in arr which will always contain an even amount of integers, and determine how they can be split into two even sets of integers each so that both sets add up to the same number. 
 * 
 * If this is impossible return -1. If it's possible to split the array into two sets, then return a string representation of the first set followed by the second set with each integer separated by a comma and both sets sorted in ascending order. 
 * 
 * The set that goes first is the set with the smallest first integer.

For example: if arr is [16, 22, 35, 8, 20, 1, 21, 11], then your program should output 1,11,20,35,8,16,21,22
Examples
Input: new int[] {1,2,3,4}
Output: 1,4,2,3Input: new int[] {1,2,1,5}
Output: -1
*/
public class PermuteParellelArray {
	static Set<java.util.List<Integer>> set = new HashSet<java.util.List<Integer>>();

	static int iMatch = 0;

	// using recursive loop and swap the value to get all combination
	static void permute(java.util.List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			// System.out.println("i--->" + i);
			// System.out.println("k--->" + k);
			java.util.Collections.swap(arr, i, k);

			// recursive loop
			permute(arr, k + 1);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			System.out.println("add -->" + arr);

			List<Integer> copiedArray = new ArrayList<Integer>(arr);
			set.add(copiedArray);

		}
	}

	static String isSetMatch(int iMatch) {
		// System.out.println("iMatch-->" + iMatch);
		String combineListStringComma = "-1";
		for (java.util.List<Integer> arr : set) {

			int min = Collections.min(arr);

			// if statement to check the below
			// The set that goes first is the set with the smallest first integer.
			if (arr.get(0) == min) {
				// System.out.println("arr.get(0) " + arr.get(0) + " match min-->" + min);

				// divide the list into 1st half
				java.util.List<Integer> firstList = arr.subList(0, arr.size() / 2);

				int sum = firstList.stream().mapToInt(a -> a).sum();

				// if the sum of the 1st half is matching the iMatch ( the sum of "even set" as
				// mentioned in requirement) then it's the list that we looking for

				if (sum == iMatch) {
					Collections.sort(firstList);
					System.out.println("Match firstList--->" + firstList);

					// divide the list into 2nd half
					java.util.List<Integer> secondList = arr.subList(arr.size() / 2, arr.size());
					Collections.sort(secondList);
					System.out.println("Match secondList--->" + secondList);

					List<Integer> combineListInt = Stream.concat(firstList.stream(), secondList.stream())
							.collect(Collectors.toList());

					List<String> combineListString = combineListInt.stream().map(Object::toString)
							.collect(Collectors.toList());

					combineListStringComma = String.join(",", combineListString);
					System.out.println("Match combineList--->" + combineListStringComma);

					break;
				}

			}

		}
		return combineListStringComma;
	}

	static java.util.List<Integer> getIMatch(int[] arr) {
		iMatch = IntStream.of(arr).sum();
		// System.out.println("iMatch--->" + iMatch);

		List<Integer> intList = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			intList.add(i);
		}

		return intList;
	}

	public static boolean isEven() {
		boolean isEven = iMatch % 2 == 0;
		System.out.println("isEven--->" + isEven);

		if (!isEven) {
			return false;
		}

		return true;
	}

	public static String ArrayChallenge(int[] iArr) {
		// given an array, separate it by 2 lists and combine it
		// each sum from the list must be equal for both list
		String combineList = "-1";

		// get sum of the list to iMatch as static int value

		java.util.List<Integer> arrInt = getIMatch(iArr);
		boolean isEven = isEven();

		if (isEven) {
			// recursive call to construct all possible values
			permute(arrInt, 0);

			// find a first list
			combineList = isSetMatch(iMatch / 2);

			//System.out.println("combined list--->" + combineList);
			return combineList;
		}

		// Note: Improvement - the value iMatch should put in pass by value in the
		// method instead using global variable for code readability and method
		// reusability
		return combineList;
	}

	public static void main(String[] args) {

		int[] iArr = new int[] { 1, 2, 3, 4 };
		String result = ArrayChallenge(iArr);
		System.out.println("combined list--->" + result);
	}
}
