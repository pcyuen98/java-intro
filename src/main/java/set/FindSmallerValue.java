package set;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;
public class FindSmallerValue {

	public static void main(String[] args) {

		SortedSet<Double> hashSet = new TreeSet<>(Arrays.asList(new Double[] { 0.1, 1.0, 2.0 })).descendingSet();
		
		Double change = 3.1;
		for (Double value: hashSet) {
			System.out.println("value-->" + value);
			Double changeAmt = change - value;
			//System.out.println("\nchangeAmt-->" + changeAmt);
			if (changeAmt > 0) {
				
				System.out.println("change amount-->" + value);
			}
			
			
		}
		
	}

}
