package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LongestWord {

    public static String findLongestWord(String sentence) {
        // Keep only letters, numbers, and spaces
        StringBuilder cleaned = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                cleaned.append(c);
            }
        }

        // Split by spaces and find the longest word
        return Arrays.stream(cleaned.toString().split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static void main(String[] args) {
    	System.out.println("enter few words");
        Scanner scanner = new Scanner(System.in);
        System.out.print(findLongestWord(scanner.nextLine()));
        scanner.close();
    }
}
