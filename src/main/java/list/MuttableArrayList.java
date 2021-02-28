package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MuttableArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listA = new ArrayList<String>();
		List<String> listB = listA;
		
		List<String> unmodifiable = Collections.unmodifiableList(listA);

		listA.add("1");
		listA.add(null);
		System.out.println("before list A--->" + listA);
		System.out.println("before list B--->" + listB);
		System.out.println("before list unmodifiable--->" + unmodifiable);
		
		//unmodifiable.add("2");
		listB.add("3");
		
		System.out.println("after list A--->" + listA);
		System.out.println("after list B--->" + listB);
		System.out.println("after list unmodifiable--->" + unmodifiable);
		
	}

}
