package advance;

import java.util.*;
import java.util.stream.*;

class StringManipulation {
	public String solution(String S, String C) {
		String companyLower = C.toLowerCase(Locale.ENGLISH);
		Map<String, Integer> emailCounts = new HashMap<>();

		return Arrays.stream(S.split("; ")).map(name -> {
			String[] parts = name.split(" ");
			String firstName = parts[0].toLowerCase(Locale.ENGLISH);
			String lastName = parts[parts.length - 1].toLowerCase(Locale.ENGLISH).replace("-", "");

			if (lastName.length() > 8) {
				lastName = lastName.substring(0, 8);
			}

			String baseEmail = firstName + "." + lastName + "@" + companyLower + ".com";
			String finalEmail = baseEmail;

			if (emailCounts.containsKey(baseEmail)) {
				int count = emailCounts.get(baseEmail);
				count++;
				finalEmail = firstName + "." + lastName + count + "@" + companyLower + ".com";
				emailCounts.put(baseEmail, count);
			} else {
				emailCounts.put(baseEmail, 1);
			}
			return name + " <" + finalEmail + ">";
		}).collect(Collectors.joining(";\n "));
	}

	public static void main(String[] args) {
		StringManipulation sol = new StringManipulation();
		String names = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		String company = "Example";
		String result = sol.solution(names, company);
		System.out.println(result);
	}
}
