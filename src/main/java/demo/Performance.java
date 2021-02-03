// JDK hot spot command to improve performance - java  -Xmn250m demo.Performance
package demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Performance {

	public static void main(String[] args) {
		listArray();
		// testStringArray();
		// testHashSet();
		// arrayOnly();
	}

	public static void listArray() {
		List<Date> mylist = new ArrayList<Date>();

		String dateString = new Date().toString();
		long before = System.currentTimeMillis();

		for (int i = 0; i < 10000000; i++) {

			mylist.add(new Date());

		}

		long after = System.currentTimeMillis();
		System.out.println("Java List time taken in miliseconds--->" + (after - before));
	}

	public static void arrayOnly() {
		Object[] array = new Object[10000000];

		String dateString = new Date().toString();
		long before = System.currentTimeMillis();

		for (int i = 0; i < 10000000; i++) {

			array[i] = new Date();

		}

		long after = System.currentTimeMillis();
		System.out.println("Java array time taken in miliseconds--->" + (after - before));
	}

	public static void testStringArray() {
		String[] stringArray = new String[100000000];

		long before = System.currentTimeMillis();

		String dateString = new Date().toString();
		for (int i = 0; i < 100000000; i++) {

			stringArray[i] = dateString;

		}

		long after = System.currentTimeMillis();
		System.out.println("Java String Array time taken in miliseconds--->" + (after - before));
	}

	public static void testHashSet() {
		HashSet<Date> hashSet = new HashSet<Date>();

		long before = System.currentTimeMillis();

		String dateString = new Date().toString();
		for (int i = 0; i < 10000000; i++) {

			hashSet.add(new Date());

		}

		long after = System.currentTimeMillis();
		System.out.println("Java hashSet time taken in miliseconds--->" + (after - before));
	}

	public static void testLinkList() {
		Vector<String> vector = new Vector<String>();

		long before = System.currentTimeMillis();

		String dateString = new Date().toString();
		for (long i = 0; i < 100000000; i++) {

			vector.add(dateString);

		}

		long after = System.currentTimeMillis();
		System.out.println("Java vector time taken in miliseconds--->" + (after - before));
	}
}
