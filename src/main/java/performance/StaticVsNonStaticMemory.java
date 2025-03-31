package performance;

import java.util.ArrayList;

public class StaticVsNonStaticMemory {

    static ArrayList<Integer> staticList = new ArrayList<>();

    public static void main(String[] args) {
        StaticVsNonStaticMemory demo = new StaticVsNonStaticMemory();

        // Static List Time Measurement
        long startTimeStatic = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            staticList.add(i);
        }
        long endTimeStatic = System.currentTimeMillis();
        long staticTime = endTimeStatic - startTimeStatic;

        // Non-Static List Time Measurement
        long startTimeNonStatic = System.currentTimeMillis();
        ArrayList<Integer> nonStaticList = new ArrayList<>(); // Create inside loop to avoid reusing.
        for (int i = 0; i < 100_000_000; i++) {
            nonStaticList.add(i);
        }
        long endTimeNonStatic = System.currentTimeMillis();
        long nonStaticTime = endTimeNonStatic - startTimeNonStatic;

        System.out.println("Static List Time (ms): " + staticTime);
        System.out.println("Non-Static List Time (ms): " + nonStaticTime);
    }
}