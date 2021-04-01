package list;

import java.util.ArrayList;
import java.util.Iterator;

// Fail-Fast and Fail -Safe 
// Any changes in the collection, such as removing element from 
// the collection during a thread is iterating collection then it 
// throw concurrent modification exception. 
// Enumeration  is Fail safe in nature. It doesn’t throw concurrent modification exception 

public class IteratorList {

	public static void main(String[] args) {
		// Create and populate the list
		ArrayList<String> list = new ArrayList<String>();

		list.add("a");
		list.add("b");
		list.add("c");

		// Create an iterator for the list
		// using iterator() method
		Iterator<String> iter = list.iterator();

		// Displaying the values after iterating
		// through the list
		System.out.println("\nThe iterator values" + " of list are: ");
		
		// new way of looping
		//iter.forEachRemaining((str) -> System.out.println(str));
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
			
		}
	}

}
