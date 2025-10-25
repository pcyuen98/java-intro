package advance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindLambdaUnique {
    public static void main(String[] args) {
        // Sample ArrayList with duplicates
        List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "mango", "banana", "grape");

        // Keep only elements that appear once
        Set<String> uniques = items.stream()
                .filter(e -> Collections.frequency(items, e) == 1)
                .collect(Collectors.toSet());

        System.out.println("Unique (non-duplicates): " + uniques);
    }
}