package demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Performance {
	
	public static void main(String[] args) {
		List<Date> mylist = new ArrayList<Date>();

		long before = System.currentTimeMillis();

		for (int i = 0; i < 10000000; i++) {
			
			mylist.add(new Date());

		}

		long after = System.currentTimeMillis();
		System.out.println("Java time taken in miliseconds--->" + (after - before) );

	}

}
