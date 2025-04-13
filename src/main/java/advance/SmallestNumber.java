package advance;

import java.util.*;
import java.util.stream.*;

class SmallestNumber {
    public int solution(int[] A) {
        Set<Integer> positiveSet = Arrays.stream(A)
            .filter(n -> n > 0)
            .boxed()
            .collect(Collectors.toSet());

        for (int i = 1; i <= A.length + 1; i++) {
            if (!positiveSet.contains(i)) {
                return i;
            }
        }

        return A.length + 1;
    }

    public static void main(String[] args) {
    	SmallestNumber sol = new SmallestNumber();

        int[] A1 = {1, 3, 6, 4, 1, 2};
        int[] A2 = {1, 2, 3};
        int[] A3 = {-1, -3};

        System.out.println("Missing integer (A1): " + sol.solution(A1)); // 5
        System.out.println("Missing integer (A2): " + sol.solution(A2)); // 4
        System.out.println("Missing integer (A3): " + sol.solution(A3)); // 1
    }
}
