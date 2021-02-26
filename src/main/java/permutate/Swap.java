package permutate;

import java.util.ArrayList;
import java.util.Collections;

public class Swap {
	public static void main(String[] args) {
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("a");
		mylist.add("b");
		mylist.add("c");
		mylist.add("d");

		System.out.println("Original List : \n" + mylist);

// Swap items at indexes 1 and 2 
		Collections.swap(mylist, 0, 1);

		System.out.println("\nAfter swap(mylist) : \n" + mylist);

// Swap items at indexes 1 and 3 
		//Collections.swap(mylist, 3, 1);

		//System.out.println("\nAfter swap(mylist, 3, 1) : \n" + mylist);
	}
}
