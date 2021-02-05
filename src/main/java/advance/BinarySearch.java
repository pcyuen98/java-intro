package advance;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	/*
	 * K = numberOfBlocks M = maxNumber A = array
	 */

	public int solution(int K, int M, int[] A) {

		int min = 0;
		int max = 0;

		for (int i = 0; i < A.length; i++) {
			max += A[i];
			min = Math.max(min, A[i]);
		}

		if (K == 1)
			return max;

		if (K >= A.length)
			return min;

		int result = min;

		while (min <= max) {

			int mid = (min + max) / 2;

			if (check(mid, K, A)) {

				max = mid - 1;
				result = mid;

			} else {

				min = mid + 1;

			}

		}

		return result;
	}

	private boolean check(int mid, int k, int[] a) {

		int sum = 0;

		for (int i = 0; i < a.length; i++) {

			sum += a[i];

			if (sum > mid) {
				sum = a[i];
				k--;
			}

			if (k == 0)
				return false;

		}

		return true;

	}
}
