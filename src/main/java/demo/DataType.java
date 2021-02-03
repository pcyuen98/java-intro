package demo;

import java.util.Arrays;
import java.util.List;

public class DataType {

	final static String seven = "aeiou";

	public static void main(String args[]) {
		// Introduction to Datatypes
		// we will name variables as one, two, three...

		// number datatype

		int one = 1; // integer
		System.out.println("one -->" + one);

		float two = 1.2f; // float
		System.out.println("two -->" + two);

		// NONE datatype
		Object four = null;
		System.out.println("four -->" + four);

		// string datatype
		String five = "We Love Study Today";
		System.out.println("five -->" + five);

		// list datatype - Can Change!

		List<Integer> six = Arrays.asList(1, 2, 4, 8 , 8);

		System.out.println("ArrayList before update: " + six);
		// Updating 1st element
		six.set(0, 999);

		System.out.println("six -->" + six);

		six.set(0, 999);

		List<Integer> sixFirstValue = six;

		System.out.println("six first value -->" + sixFirstValue);

		// tuples

		System.out.println("seven -->" + seven);

		// In basic Java, it doesn't has tuple complex data type but normal string that can't
		// be changed using Final declaration above
		// Tuple in Python - Cannot Change!, if can then US President now is Trump on
		// Nov 2020
		// seven = "z";
		// System.out.println("seven -->" + seven);
		
		// Tuple can added to Java using Maven javatuples which is similar to Python pip new add on
		// it's advance stuff for Java
		// https://howtodoinjava.com/java/java-misc/java-tuples/#:~:text=Java%20doesn't%20have%20any,of%20data%20types%20by%20design.

	}

}
