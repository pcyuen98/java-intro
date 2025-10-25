package advance;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicatesLambda {
public static void main(String[] args) {
// Sample ArrayList with duplicates
List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "mango", "banana", "grape");

Set<String> seen = new HashSet<>();  

    // Stream with simplified lambda  
    Set<String> duplicates = items.stream()  
            .filter(e -> !seen.add(e)) // if add() fails, it's a duplicate  
            .collect(Collectors.toSet());  

    System.out.println("Duplicates: " + duplicates);  
}

}