package arithmetic;

/**
 * ===========================================================
 *  JAVA LEVEL 1 & 2 — CHALLENGES DOCUMENTATION
 *  Challenge 1: How Will You Compare?
 *  Challenge 2: Java — Multi Sum
 * ===========================================================
 *
 *  @author  Curriculum: Java Level 1–2
 *  @version 1.0
 *  @since   2025-10-25
 *
 * ===========================================================
 *  CHALLENGE 1 — HOW WILL YOU COMPARE?
 * ===========================================================
 *
 *  <h2>Objective</h2>
 *  Create a Comparator class that includes three overloaded
 *  {@code compare} methods. Each method compares two inputs
 *  and returns a boolean result.
 *
 *  <h3>Method Specifications</h3>
 *
 *  <ul>
 *      <li>{@code boolean compare(String a, String b)}
 *          <ul>
 *              <li>Returns {@code true} if {@code a.equals(b)}</li>
 *              <li>Returns {@code false} otherwise</li>
 *          </ul>
 *      </li>
 *
 *      <li>{@code boolean compare(int a, int b)}
 *          <ul>
 *              <li>Returns {@code true} if {@code a == b}</li>
 *              <li>Returns {@code false} otherwise</li>
 *          </ul>
 *      </li>
 *
 *      <li>{@code boolean compare(int[] a, int[] b)}
 *          <ul>
 *              <li>Returns {@code true} if both arrays have equal length
 *                  <em>and</em> identical elements at every index.</li>
 *              <li>Returns {@code false} otherwise.</li>
 *          </ul>
 *      </li>
 *  </ul>
 *
 *  <h3>Constraints</h3>
 *  <ul>
 *      <li>String length ≤ 2000</li>
 *      <li>Integer value ≤ 100,000</li>
 *      <li>Array length ≤ 10</li>
 *  </ul>
 *
 *  <h3>Input Format</h3>
 *  <pre>
 *  The first line: integer T (number of test cases)
 *
 *  Each test case format:
 *  Type 1 (String comparison):
 *      1
 *      <string a>
 *      <string b>
 *
 *  Type 2 (Integer comparison):
 *      2
 *      <int a>
 *      <int b>
 *
 *  Type 3 (Array comparison):
 *      3
 *      <length of a> <length of b>
 *      <space-separated integers of array a>
 *      <space-separated integers of array b>
 *  </pre>
 *
 *  <h3>Output Format</h3>
 *  <ul>
 *      <li>Print "Same" if the values are equal.</li>
 *      <li>Print "Different" otherwise.</li>
 *  </ul>
 *
 *  <h3>Sample Input 0</h3>
 *  <pre>
 *  3
 *  1
 *  hello world
 *  hello world
 *  2
 *  4
 *  6
 *  3
 *  3 3
 *  1 2 3
 *  1 2 3
 *  </pre>
 *
 *  <h3>Sample Output 0</h3>
 *  <pre>
 *  Same
 *  Different
 *  Same
 *  </pre>
 *
 *  <h3>Explanation 0</h3>
 *  <table border="1">
 *      <tr><th>Case</th><th>Type</th><th>a</th><th>b</th><th>Output</th><th>Reason</th></tr>
 *      <tr><td>1</td><td>String</td><td>"hello world"</td><td>"hello world"</td><td>Same</td><td>Strings match exactly</td></tr>
 *      <tr><td>2</td><td>Integer</td><td>4</td><td>6</td><td>Different</td><td>Integers not equal</td></tr>
 *      <tr><td>3</td><td>Array</td><td>{1,2,3}</td><td>{1,2,3}</td><td>Same</td><td>Arrays identical</td></tr>
 *  </table>
 *
 *  <h3>Sample Input 1</h3>
 *  <pre>
 *  2
 *  3
 *  3 4
 *  1 2 3
 *  1 2 3 4
 *  1
 *  HackerRank
 *  hackerRank
 *  </pre>
 *
 *  <h3>Sample Output 1</h3>
 *  <pre>
 *  Different
 *  Different
 *  </pre>
 *
 *  <h3>Explanation 1</h3>
 *  <table border="1">
 *      <tr><th>Case</th><th>Type</th><th>a</th><th>b</th><th>Output</th><th>Reason</th></tr>
 *      <tr><td>1</td><td>Array</td><td>{1,2,3}</td><td>{1,2,3,4}</td><td>Different</td><td>Lengths differ</td></tr>
 *      <tr><td>2</td><td>String</td><td>"HackerRank"</td><td>"hackerRank"</td><td>Different</td><td>Case-sensitive mismatch</td></tr>
 *  </table>
 *
 * ===========================================================
 *  CHALLENGE 2 — JAVA: MULTI SUM
 * ===========================================================
 *
 *  <h2>Objective</h2>
 *  Create an Arithmetic class that includes two overloaded
 *  {@code sum} methods.
 *
 *  <h3>Method Specifications</h3>
 *
 *  <ul>
 *      <li>{@code public Integer sum(Integer[] ints)}
 *          <ul>
 *              <li>Returns the total sum of all integers in the array.</li>
 *          </ul>
 *      </li>
 *      <li>{@code public String sum(String[] strings)}
 *          <ul>
 *              <li>Returns all strings concatenated together in order.</li>
 *          </ul>
 *      </li>
 *  </ul>
 *
 *  <h3>Constraints</h3>
 *  <ul>
 *      <li>1 ≤ array length ≤ 100</li>
 *      <li>Integers ∈ [1, 100]</li>
 *      <li>Strings contain only English letters (A–Z, a–z), ≤ 100 chars each</li>
 *  </ul>
 *
 *  <h3>Input Format</h3>
 *  A single line of space-separated input consisting of either:
 *  <ul>
 *      <li>Integers → for sum of numbers</li>
 *      <li>Strings → for concatenation</li>
 *  </ul>
 *
 *  <h3>Output Format</h3>
 *  <ul>
 *      <li>If integers → print the total sum.</li>
 *      <li>If strings → print the concatenated result.</li>
 *  </ul>
 *
 *  <h3>Sample Input 0</h3>
 *  <pre>
 *  1 2 3 4 5
 *  </pre>
 *
 *  <h3>Sample Output 0</h3>
 *  <pre>
 *  15
 *  </pre>
 *
 *  <h3>Sample Input 1</h3>
 *  <pre>
 *  the Fox is coming in
 *  </pre>
 *
 *  <h3>Sample Output 1</h3>
 *  <pre>
 *  theFoxiscomingin
 *  </pre>
 *
 *  <h3>Summary</h3>
 *  <table border="1">
 *      <tr><th>Input Type</th><th>Method Used</th><th>Output</th></tr>
 *      <tr><td>Integer Array</td><td>sum(Integer[])</td><td>Sum of numbers</td></tr>
 *      <tr><td>String Array</td><td>sum(String[])</td><td>Concatenated string</td></tr>
 *  </table>
 *
 * ===========================================================
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors; // Added for Collectors.joining()

public class Arithmetic {

	/**
	 * Overloaded sum method for Integer arrays. Returns the sum of all elements in
	 * the array.
	 *
	 * @param ints An array of Integer objects.
	 * @return The sum of the elements as an Integer.
	 */
	public Integer sum(Integer[] ints) {
		// Refactored using Stream API with mapToInt and sum()
		return Arrays.stream(ints).mapToInt(Integer::intValue) // Use method reference for mapping to int
				.sum();
	}

	/**
	 * Overloaded sum method for String arrays. Returns the concatenation of all
	 * strings in the array in order.
	 *
	 * @param strings An array of String objects.
	 * @return The concatenated string.
	 */
	public String sum(String[] strings) {
		// Refactored using Stream API and Collectors.joining()
		return Arrays.stream(strings).collect(Collectors.joining());
	}

	public static void main(String args[]) throws Exception {
		// Read the entire line of input from STDIN
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = br.readLine();

		// Split the input line by spaces to get individual tokens
		String[] tokens = inputLine.split(" ");

		// Determine the type of input (Integers or Strings)
		// We assume all elements will be of the same type.
		// We can check the first token to see if it's a valid integer.
		boolean isIntegerArray = true;

		if (tokens.length > 0) {
			try {
				// Attempt to parse the first token as an Integer.
				Integer.parseInt(tokens[0]);
				// If successful, the input is an array of Integers.
				isIntegerArray = true;
			} catch (NumberFormatException e) {
				// If parsing fails, the input is an array of Strings.
				isIntegerArray = false;
			}
		} else {
			// If the input line is empty, just exit.
			return;
		}

		// Initialize the Arithmetic class instance
		Arithmetic arithmetic = new Arithmetic();

		if (isIntegerArray) {
			// Case 1: Integer Array Input
			Integer[] integerArray = new Integer[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				// The problem guarantees they are in the range [1, 100], so parsing is safe.
				integerArray[i] = Integer.parseInt(tokens[i]);
			}

			// Call the Integer sum method
			Integer result = arithmetic.sum(integerArray);
			System.out.println(result);

		} else {
			// Case 2: String Array Input
			// The tokens array itself is already a String array, ready to be used.
			String[] stringArray = tokens;

			// Call the String sum method
			String result = arithmetic.sum(stringArray);
			System.out.println(result);
		}
	}
}
