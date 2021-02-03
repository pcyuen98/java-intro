package demo;
// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/start/

import java.util.LinkedList;
import java.util.List;

public class Rotation {

	public static int[] solution(int[] A, int K) {

		List<Integer> list = new LinkedList<Integer>();
		for (int currentInt : A) {
			list.add(currentInt);
		}

		for (int i = 0; i < K; i++) {
			list = rotate(list);
		}

		int[] arr = list.parallelStream().mapToInt(Integer::intValue).toArray();

		System.out.println("return array:" + list);
		return arr;
	}

	public static List<Integer> rotate(List<Integer> list) {
		int head = list.get(0);
		int tail = list.get(list.size() - 1);

		//System.out.println("head:" + head);
		//System.out.println("tail:" + tail);

		//System.out.println("before list:" + list);
		// list.add(tail);

		list.remove(list.size() - 1);
		//System.out.println("after list:" + list);

		List<Integer> newList = new LinkedList<Integer>();
		newList.add(tail);
		for (int i : list) {
			newList.add(i);
		}

		return newList;

	}

	public static void main(String args[]) {
		int[] A = { 3, 8, 9, 7, 6 };
		int[] processed = solution(A, 3);

		System.out.println("return array:" + processed);
	}
}
