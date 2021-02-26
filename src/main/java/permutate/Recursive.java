package permutate;

import java.util.HashSet;
import java.util.Set;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// recursive(0);
		System.out.println(generatePerm("==0"));
	}

	public static Set<String> generatePerm(String input) {
		System.out.println("\ninput----> " + input);
		String oriInput = input;
		Set<String> set = new HashSet<String>();
		if (input == "")
			return set;

		Character a = input.charAt(0);
		System.out.println("\n a----> " + a);
		if (input.length() > 1) {
			input = input.substring(1);

			Set<String> permSet = generatePerm(input);
			System.out.println("\n\npermSet----> " + permSet + " continue from Input--->" + oriInput + " a--->" + a);
			for (String x : permSet) {
				System.out.println("x----> " + x);
				for (int i = 0; i <= x.length(); i++) {

					//System.out.println("\n inner loop " + i + " a ----> " + a + "   x--->" + x);
					//System.out.println("x.substring(0, i)----> " + x.substring(0, i));
					//System.out.println("a----> " + a);
					//System.out.println("x.substring(i)----> " + x.substring(i));
					String addStr = x.substring(0, i) + a + x.substring(i);
					System.out.println("addStr----> " + addStr);
					set.add(addStr);
				}
			}
		} else {
			set.add(a + "");
		}

		System.out.println("\nexit----> " + input + " set--->" + set);
		return set;
	}
}
