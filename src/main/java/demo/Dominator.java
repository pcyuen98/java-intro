// https://app.codility.com/programmers/lessons/8-leader/

package demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dominator {

	public static void main(String[] arg) {
		int A[] = { 4, 3, 4, 4, 4, 2 };
		System.out.println("result: " + solution(A));
	}

	public static int solution(int A[]) {

		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

		for (int i = 0; i < A.length; i++) {
			//System.out.println("A[i]= :" + A[i] );
			boolean isNew = map.get(A[i]) == null;

			if (isNew) {
				Set<Integer> hashset = new HashSet<Integer>();
				hashset.add(i);
				map.put(A[i], hashset);
			} else {
				Set<Integer> hashset = map.get(A[i]);
				hashset.add(i);

				//int totalArrays = A.length / 2;
				//System.out.println("hashset.size :" + hashset.size() + " totalArrays : " + totalArrays);
				if (hashset.size() > A.length / 2) {
					//System.out.println("largest value found at position : " + i);
					System.out.println("map : " + map);
					return i;
				}
			}

		}

		System.out.println("map : " + map);
		return -1;
	}
}
