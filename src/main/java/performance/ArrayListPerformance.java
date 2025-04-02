package performance;

import java.util.ArrayList;

import util.PressAnyKey;

public class ArrayListPerformance {

    static ArrayList<Integer> staticList = new ArrayList<>();

    public static void main(String[] args) {

    	PressAnyKey.run();
               
    	long startTimeStatic = System.currentTimeMillis();
        for (int i = 0; i < 400_000_000; i++) {
        //	System.out.println("Running-->" + i);
            staticList.add(i);
        }
        long endTimeStatic = System.currentTimeMillis();
        long staticTime = endTimeStatic - startTimeStatic;

        System.out.println("Static List Time (ms): " + staticTime);
    }
}
