// https://app.codility.com/demo/take-sample-test/

package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Integer2ArrayList {
	public int solution(int[] A) {
		Arrays.sort(A);
		int min = A[A.length-1] + 1;
		int cap = A.length; // for efficiency — no need to calculate or access the array object’s length
							// property per iteration

		List<Integer> intList = new ArrayList<Integer>(A.length);
		for (int i : A) {
			intList.add(i);
		}

		for (int i = 1; i < cap + 1; i++) {

			boolean isContain = intList.contains(i);
			System.out.println("i =" + i + " isCOntain=" + isContain);
			if (!isContain) {
				min = i;
				break;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		int i[] = { -100 };
		int min = new Integer2ArrayList().solution(i);
		System.out.println(min);
	}
}
