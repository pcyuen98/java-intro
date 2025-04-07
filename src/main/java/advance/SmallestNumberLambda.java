package advance;

import java.util.Arrays;

public class SmallestNumberLambda {

    public static void main(String[] args) {
        int[] A = {1, 1000, 6, 4, 1, 2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
    	return Arrays.stream(A).min().orElseThrow();
    }
}
