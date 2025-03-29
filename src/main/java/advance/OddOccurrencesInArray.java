package advance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class OddOccurrencesInArray {
    public int solution(int[] A) {
        Map<Integer, Integer> counts = new HashMap<>();

        Arrays.stream(A).forEach(num -> counts.put(num, counts.getOrDefault(num, 0) + 1));

        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0); // Should not reach 0 based on problem constraints
    }

    public static void main(String[] args) {
        OddOccurrencesInArray solution = new OddOccurrencesInArray();
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution.solution(A)); // Output: 7

        int[] B = {1, 2, 1, 3, 2};
        System.out.println(solution.solution(B)); // Output: 3

        int[] C = {1};
        System.out.println(solution.solution(C)); // Output: 1

        int[] D = {1, 2, 2, 3, 3, 4, 4};
        System.out.println(solution.solution(D)); //Output: 1

    }
}
