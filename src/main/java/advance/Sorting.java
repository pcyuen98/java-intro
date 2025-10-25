package advance;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String args[]) {
		int[] i = { 2, 1, 1, 2, 3, 1 };

		
		Set<Object> set = Arrays.stream(i).boxed().collect(Collectors.toSet());
		System.out.println("set-->" + set);
		System.out.println("set:" + set.size());
	}
}
