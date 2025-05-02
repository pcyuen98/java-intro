package advance;

import java.util.*;
import java.util.stream.*;

/**
 * The {@code StringManipulationImproved} class generates unique email addresses
 * for a list of full names using a specified company name.
 *
 * <p><b>Main Features:</b></p>
 * <ul>
 *   <li>Parses semicolon-separated full names with optional spaces.</li>
 *   <li>Handles names with multiple parts and hyphenated last names.</li>
 *   <li>Normalizes email addresses to lowercase and company format.</li>
 *   <li>Ensures uniqueness of emails by tracking duplicates using a map.</li>
 *   <li>Outputs full names with corresponding emails in formatted string.</li>
 * </ul>
 *
 * <p><b>Key Implementation Points:</b></p>
 * <ul>
 *   <li>Converts company name to lowercase to ensure email domain consistency.</li>
 *   <li>Uses {@code S.split(";\\s*")} to support flexible spacing after semicolons.</li>
 *   <li>Uses {@code fullName.trim().split("\\s+")} to split names with irregular spacing.</li>
 *   <li>Extracts first and last name from name parts; trims last name to 8 characters max.</li>
 *   <li>Removes hyphens in last names using {@code replaceAll("-", "")}.</li>
 *   <li>Generates email in the format: {@code firstname.lastname@example.com}.</li>
 *   <li>Maintains a {@code HashMap<String, Integer>} to track how many times each email base is used.</li>
 *   <li>If a duplicate is found, appends a number (e.g. john.doe2@example.com).</li>
 *   <li>Returns a formatted string joining all full name/email pairs, separated by {@code ";\n "}.</li>
 * </ul>
 *
 * <p><b>Example:</b></p>
 * <pre>{@code
 * Input:  "John Doe; Jane Smith; John Doe"
 * Output: "John Doe <john.doe@example.com>;
 *          Jane Smith <jane.smith@example.com>;
 *          John Doe <john.doe2@example.com>"
 * }</pre>
 *
 * <h3>Comparison: HashMap vs ConcurrentHashMap</h3>
 *
 * <table border="1">
 * <tr><th>Feature</th><th>HashMap</th><th>ConcurrentHashMap</th></tr>
 * <tr><td>Thread Safety</td><td>Not thread-safe</td><td>Thread-safe</td></tr>
 * <tr><td>Null Keys/Values</td><td>Allows one null key and multiple null values</td><td>Does not allow null keys or values</td></tr>
 * <tr><td>Performance (Single-threaded)</td><td>Faster</td><td>Slightly slower due to locking mechanisms</td></tr>
 * <tr><td>Performance (Multi-threaded)</td><td>Requires external synchronization</td><td>Optimized for concurrent access</td></tr>
 * </table>
 */

public class StringManipulationImproved {

	public String solution(String S, String C) {
		String companyLower = C.toLowerCase(Locale.ENGLISH);
		Map<String, Integer> emailCounts = new HashMap<>();

		return Arrays.stream(S.split(";\\s*")) 
				// [Improvement 1] // Makes parsing more flexible — handles inconsistent
				// spaces like ";" or "; " gracefully.
				// 1+ whitespace between words
				
				.map(fullName -> {
					String[] parts = fullName.trim().split("\\s+"); // [Improvement 2] // Supports full names with
																	// irregular spaces (e.g. "Mary Jane
																	// Watson-Parker"), reducing chances of
																	// ArrayIndexOutOfBoundsException.
																	//; followed by 0+ spaces
					String firstName = parts[0].toLowerCase(Locale.ENGLISH);
					String lastName = parts[parts.length - 1].toLowerCase(Locale.ENGLISH).replaceAll("-", "");

					lastName = lastName.length() > 8 ? lastName.substring(0, 8) : lastName;

					String base = firstName + "." + lastName;
					String email = base + "@" + companyLower + ".com";

					int count = emailCounts.getOrDefault(email, 0); // [Improvement 3] // Improves clarity, reduces
																	// potential for logic errors, and avoids duplicate
																	// lookups into the map.
					emailCounts.put(email, count + 1);

					if (count > 0) {
						email = base + (count + 1) + "@" + companyLower + ".com";
					}

					return fullName.trim() + " <" + email + ">";
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
