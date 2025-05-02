package exercise_print_with_conditions;

public class ExercisePrintWithCondition {

    public static void main(String[] args) {
        int aNumber = 100;

        if (aNumber == 100) {
            System.out.println("the value is 100"); // If True, print A
        } else if (aNumber == 200) {
            System.out.println("the value is 200"); // If True, print A
        } else if ( aNumber != 100 & aNumber != 200 ) {
            System.out.println("unknown value"); // If True, print A
        }
    }	
}
