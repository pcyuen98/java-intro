package permutate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PermuteParellelArray {
	static Set<java.util.List<Integer>> set = new HashSet<java.util.List<Integer>>();

	static void permute(java.util.List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			// System.out.println("i--->" + i);
			// System.out.println("k--->" + k);
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			System.out.println("add -->" + arr);

			List<Integer> copiedArray = new ArrayList<Integer>(arr);
			set.add(copiedArray);

		}
	}

	static void isSetMatch(int iMatch) {		
		System.out.println("iMatch-->" + iMatch);
		for (java.util.List<Integer> arr : set) {

			int min = Collections.min(arr);

			if (arr.get(0) == min) {
				System.out.println("match min-->" + min);
				java.util.List<Integer> firstList = arr.subList(0, arr.size() / 2);

				int sum = firstList.stream().mapToInt(a -> a).sum();

				if (sum == iMatch) {
					Collections.sort(firstList);
					System.out.println("Match firstList--->" + firstList);

					java.util.List<Integer> secondList = arr.subList(arr.size() / 2, arr.size());
					Collections.sort(secondList);
					System.out.println("Match secondList--->" + secondList);

					List<Integer> combineList = Stream.concat(firstList.stream(), secondList.stream())
							.collect(Collectors.toList());

					System.out.println("Match combineList--->" + combineList);
					break;
				}

			}

		}

	}

	static int iMatch = 0;

	static java.util.List<Integer> getIMatch(int[] arr) {
		iMatch = IntStream.of(arr).sum();
		// System.out.println("sum--->" + sum);

		List<Integer> intList = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			intList.add(i);
		}

		return intList;
	}

	public static void main(String[] args) {
		
		int[] iArr = new int[] { 1,2,3,4 };
		
		// given an array, separate it by 2 lists and combine it
		// each sum from the list must be equal for both list
		java.util.List<Integer> arrInt = getIMatch(iArr);
		PermuteParellelArray.permute(arrInt, 0);
		isSetMatch(iMatch/2);
	}
}
