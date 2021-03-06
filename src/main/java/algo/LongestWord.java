package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestWord {

	public static final String REG_EXP_CHAR_ONLY = "(?=.*?[a-zA-Z0-9 ])";

	public static String LongestWord(String sen) {
	
		StringBuffer strBuffer = new StringBuffer();
		for (String c : sen.split("")) {
			//System.out.println("c--------->" + c);
			if (isValid(c)) {

				strBuffer.append(c);

			}
		}

		//System.out.println(strBuffer.toString());
		String longest = Arrays.stream(strBuffer.toString().split(" ")).max(Comparator.comparingInt(String::length))
				.orElse(null);

		return longest;
	}

	public static boolean isValid(String c) {
		// System.out.println("char -->" + c);
		Pattern pattern = Pattern.compile(REG_EXP_CHAR_ONLY);
		Matcher matcher = pattern.matcher(c);
		boolean matchFound = matcher.find();
		if (matchFound) {
			// System.out.println("Match found");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// keep this function call here
		// @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		// System.out.print(LongestWord("a confusing /:sentence:/[ this is
		// not!!!!!!!~"));

		s = new Scanner(System.in);
		System.out.print(LongestWord(s.nextLine()));
	}
}
