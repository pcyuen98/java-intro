package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Arithmetic {

    /**
     * Overloaded sum method for Integer arrays. Returns the sum of all elements in the array.
     *
     * @param ints an array of Integer objects
     * @return the sum of the elements as an Integer
     */
    public Integer sum(Integer[] ints) {
        return Arrays.stream(ints)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Overloaded sum method for String arrays. Returns the concatenation of all strings in the array.
     *
     * @param strings an array of String objects
     * @return the concatenated string
     */
    public String sum(String[] strings) {
        return Arrays.stream(strings).collect(Collectors.joining());
    }

    public static void main(String[] args) throws Exception {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var inputLine = br.readLine();

            if (inputLine == null || inputLine.isBlank()) {
                System.err.println("No input provided.");
                return;
            }

            var tokens = inputLine.trim().split("\\s+");

            // Try parsing the first token to decide input type
            boolean isIntegerArray = Arrays.stream(tokens).allMatch(token -> token.matches("-?\\d+"));

            var arithmetic = new Arithmetic();

            if (isIntegerArray) {
                // Use map to parse to Integer directly
                var integerArray = Arrays.stream(tokens)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

                var result = arithmetic.sum(integerArray);
                System.out.println(result);
            } else {
                var result = arithmetic.sum(tokens);
                System.out.println(result);
            }
        }
    }
}
