package advance;

import java.util.*;

public class Fibonacci {

    static class Jump {
        int position;
        int moves;

        Jump(int position, int moves) {
            this.position = position;
            this.moves = moves;
        }
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Generate all Fibonacci numbers <= N + 1 (including jump to other bank)
        List<Integer> fibs = generateFibonacciUpTo(N + 1);

        // BFS queue to hold positions and move counts
        Queue<Jump> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        // Initial positions the frog can jump to from position -1
        for (int fib : fibs) {
            int pos = fib - 1;
            if (pos == N) {
                return 1; // Direct jump to the bank
            }
            if (pos < N && A[pos] == 1) {
                queue.add(new Jump(pos, 1));
                visited[pos] = true;
            }
        }

        // BFS to find minimum number of jumps
        while (!queue.isEmpty()) {
            Jump current = queue.poll();
            for (int fib : fibs) {
                int nextPos = current.position + fib;

                if (nextPos == N) {
                    return current.moves + 1; // Reached the other bank
                }

                if (nextPos < N && A[nextPos] == 1 && !visited[nextPos]) {
                    queue.add(new Jump(nextPos, current.moves + 1));
                    visited[nextPos] = true;
                }
            }
        }

        return -1; // Cannot reach the other bank
    }

    // Generate Fibonacci numbers up to max
    private static List<Integer> generateFibonacciUpTo(int max) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(2);
        int next;
        while ((next = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2)) <= max) {
            fibs.add(next);
        }
        return fibs;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        int result = solution(A);
        System.out.println("Minimum jumps: " + result); // Should print 3
    }
}
