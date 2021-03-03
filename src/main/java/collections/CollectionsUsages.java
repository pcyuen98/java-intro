package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsUsages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrayList = new ArrayList<Integer>();

		Collections.addAll(arrayList, 1, 2, 3);

		System.out.println(" min---> " + Collections.min(arrayList));
		System.out.println(" max---> " + Collections.max(arrayList));

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		Collections.copy(arrayList, linkedList);

		System.out.println("similarity--->" + Collections.disjoint(arrayList, linkedList));

		Collections.swap(arrayList, 0, 1);

		System.out.println("After Swap--->" + arrayList);

		Collections.replaceAll(arrayList, 1, 99);

		System.out.println("After Replace--->" + arrayList);
		
		Collections.addAll(arrayList, 8,9);
		
		System.out.println("After add all--->" + arrayList);

	}
}
