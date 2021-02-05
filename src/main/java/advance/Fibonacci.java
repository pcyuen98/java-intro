package advance;

/*The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2
A small frog wants to get to the other side of a river. 

The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). 

The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. 

Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. 
Array A contains only 0s and/or 1s:

0 represents a position without a leaf;
1 represents a position containing a leaf.
The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). 
The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. 
If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fibonacci {
	public static class Jump {
		int pos;
		int move;

		public Jump(int pos, int move) {
			this.pos = pos;
			this.move = move;
		}
	}

	public static int solution(int[] A) {

		int n = A.length;
		List<Integer> fibs = fibArray(n + 1);
		Queue<Jump> positions = new LinkedList<Jump>();
		boolean[] visited = new boolean[n + 1];

		if (A.length <= 2)
			return 1;

		for (int i = 0; i < fibs.size(); i++) {
			int initPos = fibs.get(i) - 1;
			if (A[initPos] == 0)
				continue;
			positions.add(new Jump(initPos, 1));
			visited[initPos] = true;
		}

		for (int i = 0; i < visited.length; i++) {

				System.out.println("visited ==>" + visited[i]);
		}
		
		for (Jump jump: positions) {
			System.out.println("jump move ==>" + jump.move);
			System.out.println("jump pos ==>" + jump.pos);
		}
		while (!positions.isEmpty()) {
			Jump jump = positions.remove();
			for (int j = fibs.size() - 1; j >= 0; j--) {
				int nextPos = jump.pos + fibs.get(j);
				if (nextPos == n)
					return jump.move + 1;
				else if (nextPos < n && A[nextPos] == 1 && !visited[nextPos]) {
					positions.add(new Jump(nextPos, jump.move + 1));
					visited[nextPos] = true;
				}
			}
		}

		return -1;
	}

	// F(M) = F(M - 1) + F(M - 2) if M >= 2
	private static List<Integer> fibArray(int n) {
		List<Integer> fibs = new ArrayList<>();
		fibs.add(1);
		fibs.add(2);
		printFibs(fibs, n);
		while (fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2) <= n) {
			printFibs(fibs, n);
			fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
		}
		return fibs;
	}

	private static void printFibs(List<Integer> fibs, int n) {
		System.out.println("n  ==>" + n);
		System.out.println("fibs  ==>" + fibs);
		System.out.println("fibs.get(fibs.size() - 1)  ==>" + fibs.get(fibs.size() - 1));
		System.out.println("fibs.get(fibs.size() - 2)  ==>" + fibs.get(fibs.size() - 2));
	}

	public static void main(String args[]) {
		int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
		solution(A);
	}
}
