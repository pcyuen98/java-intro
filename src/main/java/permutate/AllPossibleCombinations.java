package permutate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPossibleCombinations {

	public static void main(String[] args) {
		String[] a = { "0", "1", "2" };
		List<List<String>> list = new AllPossibleCombinations().getAllCombinations(Arrays.asList(a));
		for (List<String> arr : list) {
			for (String s : arr) {
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public List<List<String>> getAllCombinations(List<String> elements) {
		List<List<String>> combinationList = new ArrayList<List<String>>();
		for (long i = 1; i < Math.pow(2, elements.size()); i++) {
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < elements.size(); j++) {
				if ((i & (long) Math.pow(2, j)) > 0) {
					list.add(elements.get(j));
				}
			}
			combinationList.add(list);
		}
		return combinationList;
	}

}