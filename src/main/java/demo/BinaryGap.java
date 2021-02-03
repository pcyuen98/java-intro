// binary gap example
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/start/

package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryGap {
	public static void main(String[] arg) {
		int dec = -1;
		System.out.println("totalGap: " + solution(dec));
	}

	public static int solution(int N) {

		int totalGap = 0;
		String bin = Integer.toBinaryString(N);

		String[] r = bin.split("1");

		List<String> list = new ArrayList<String>(Arrays.asList(r));

		char lastChar = bin.charAt(bin.length() - 1);

		if (lastChar == '0') {
			list.remove(list.size() - 1);
		}

		int largestNum = 0;
		for (String str : list) {
			if (str.length() > largestNum) {
				largestNum = str.length();
				totalGap = largestNum;
			}
		}

		return totalGap;
	}
}
