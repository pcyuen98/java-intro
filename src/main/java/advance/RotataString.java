package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotataString {

	public static int[] solution(int[] A, int K) {

		List<Integer> arrayList = new ArrayList<Integer>();

		for (int i : A) {
			arrayList.add(i);
		}

		Collections.rotate(arrayList, K);

		int[] arr = arrayList.parallelStream().mapToInt(Integer::intValue).toArray();

		return arr;
	}

	public static void main(String[] args) {

		int[] A = { 3, 8, 9, 7, 6 };
		int[] processed = solution(A, 3);

		System.out.println("return array:" + Arrays.toString(processed));

	}
}
