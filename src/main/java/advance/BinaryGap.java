// binary gap example
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/start/
// https://app.codility.com/programmers/lessons/1-iterations/
package advance;

import java.util.Arrays;

public class BinaryGap {
	public static int solution(int N) {
		String binary = Integer.toBinaryString(N);
		System.out.println("Binary Value-->" + binary);
		int maxGap = 0, currentGap = 0;
		boolean counting = false;

		for (char c : binary.toCharArray()) {
			if (c == '1') {
				maxGap = Math.max(maxGap, currentGap);
				currentGap = 0;
				counting = true;
			} else if (counting) {
				currentGap++;
			}
		}
		return maxGap;
	}

	public static int findBinaryGapLambda(int n) {
		String binary = Integer.toBinaryString(n);
		System.out.println("Binary Value-->" + binary);

		String[] zeroGroups = Arrays.stream(
			    binary.substring(binary.indexOf('1'), binary.lastIndexOf('1') + 1).split("1")
			).toArray(String[]::new);
				
		System.out.println ("zeroGroups-->" + Arrays.toString(zeroGroups));
		
		System.out.println("stream-->" + Arrays.stream(zeroGroups).filter(s -> !s.isEmpty()).mapToInt(String::length).min());
		return Arrays.stream(binary.substring(binary.indexOf('1'), binary.lastIndexOf('1') + 1).split("1"))
				.filter(s -> !s.isEmpty()).mapToInt(String::length).max().orElse(0);
	}

	public static void main(String[] args) {
		// System.out.println(findBinaryGapLambda(9)); // Output: 2
		 System.out.println(findBinaryGapLambda(529)); // Output: 4
		// System.out.println(findBinaryGapLambda(20)); // Output: 1
		// System.out.println(findBinaryGapLambda(15)); // Output: 0
	}
}
