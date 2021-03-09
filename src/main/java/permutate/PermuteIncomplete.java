package permutate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermuteIncomplete {
	static Set set = new HashSet();

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
			set.add(arr);
			System.out.println(java.util.Arrays.toString(arr.toArray()));
		}
	}

	static void isSetMatch(int iMatch) {
		Iterator itr = set.iterator();

		while (itr.hasNext()) {
			java.util.List<Integer> arr = (List) itr.next();
			System.out.println("-->" + arr);
		}
	}

	public static void main(String[] args) {
		Permute.permute(java.util.Arrays.asList(1, 2, 3, 4), 0);
		isSetMatch(5);
	}
}
