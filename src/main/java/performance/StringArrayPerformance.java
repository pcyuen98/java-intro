package performance;

public class StringArrayPerformance {

    static String[] staticArray = new String[100_000_000]; // Pre-allocate array

    public static void main(String[] args) {

        long startTimeStatic = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            staticArray[i] = String.valueOf(i); // Assign String values
        }
        long endTimeStatic = System.currentTimeMillis();
        long staticTime = endTimeStatic - startTimeStatic;

        System.out.println("Static Array Time (ms): " + staticTime);
    }
}