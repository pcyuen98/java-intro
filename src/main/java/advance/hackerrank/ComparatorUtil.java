package advance.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorUtil {

	/*
	 * How Will You Compare? Create a Comparator class that includes three
	 * overloaded compare methods:
	 * 
	 * boolean compare(int a, int b): Return true if a = b, otherwise return false.
	 * boolean compare(string a, string b): Return true if a = b, otherwise return
	 * false. boolean compare(int[] a, int[] b): Return true if both of the
	 * following conditions hold true. Otherwise, return false: The length of a =
	 * the length of b. Elements a[i] = b[i] for all indices. Note for C++
	 * implementations: Use Vector&lt;int> for the array parameters.
	 * 
	 * Constraints
	 * 
	 * For strings, 1 ≤ length of a, length of b ≤ 2000 For integers, 0 ≤ a, b ≤
	 * 10000000 For integer arrays, 1 ≤ length of a, length of b ≤ 10
	 */

	// Integer comparator
	private final Comparator<Integer> intComparator = Integer::compare;

	// Null-safe string comparator
	private final Comparator<String> stringComparator = Comparator.nullsFirst(String::compareTo);

	// Custom comparator for int arrays
	private final Comparator<int[]> intArrayComparator = 
			Comparator.nullsFirst((a, b) -> Arrays.equals(a, b) ? 0 : -1);

	// Compare two integers
	public boolean compare(int a, int b) {
		return intComparator.compare(a, b) == 0;
	}

	// Compare two strings
	public boolean compare(String a, String b) {
		return stringComparator.compare(a, b) == 0;
	}

	// Compare two integer arrays
	public boolean compare(int[] a, int[] b) {
		return intArrayComparator.compare(a, b) == 0;
	}

	// Sample test code
	public static void main(String[] args) {
		ComparatorUtil comp = new ComparatorUtil();

		// Integer comparison
		System.out.println(comp.compare(10, 10)); // true
		System.out.println(comp.compare(10, 20)); // false

		// String comparison
		System.out.println(comp.compare("hello", "hello")); // true
		System.out.println(comp.compare("hello", "world")); // false
		System.out.println(comp.compare((String) null, (String) null)); // true

		// Array comparison
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr3 = { 1, 2, 4 };
		int[] arr4 = null;

		System.out.println(comp.compare(arr1, arr2)); // true
		System.out.println(comp.compare(arr1, arr3)); // false
		System.out.println(comp.compare(arr1, arr4)); // false
		System.out.println(comp.compare((String) null, (String) null)); // true
	}
}