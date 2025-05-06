package basic.input;

import java.util.Scanner;

/**
 * 🔍 Brainstorm and discuss how to change the code below to achieve this
 * function. You can use the AI
 *
 * <ul>
 * <li><b>Separation:</b> Food and drink logic are separated into individual
 * methods, promoting single-responsibility and reducing complexity in the main
 * method.</li>
 *
 * <li><b>Maintainability:</b> The modular structure allows for easy updates.
 * New food or drink items can be added or modified by updating only relevant
 * methods without affecting the rest of the program.</li>
 *
 * <li><b>Readability:</b> Code is easier to read and understand. Avoids deeply
 * nested switch statements and groups logic in well-named, purpose-specific
 * methods.</li>
 *
 * <li><b>Error Handling:</b> Invalid user input is managed by returning
 * sentinel values (e.g., -1), making it simple to validate and handle incorrect
 * choices without cluttering business logic.</li>
 * </ul>
 * <br>
 * Note: You may use AI to generate the code with the key word "improve" ,
 * "refactor" , keyword as above. i.e. improve the code maintainability and then
 * choose the best source code
 */

public class ExerciseBasicInputFood {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Display menu
		System.out.println("Food Menu:");
		System.out.println("1. McDonald's - RM10");
		System.out.println("2. Nasi Lemak  - RM2");
		System.out.println("3. Mee Kosong  - RM1");

		System.out.print("Enter your food choice (1-3): ");
		int foodChoice = scanner.nextInt();

		System.out.println("\nDrink Menu:");
		System.out.println("1. Milo       - RM2");
		System.out.println("2. Teh Tarik  - RM1.50");
		System.out.println("3. Air Kosong - RM0");

		System.out.print("Enter your drink choice (1-3): ");
		int drinkChoice = scanner.nextInt();

		double foodPrice = 0;
		double drinkPrice = 0;
		String foodName = "";
		String drinkName = "";

		// Determine food price
		switch (foodChoice) {
		case 1:
			foodName = "McDonald's";
			foodPrice = 10;
			break;
		case 2:
			foodName = "Nasi Lemak";
			foodPrice = 2;
			break;
		case 3:
			foodName = "Mee Kosong";
			foodPrice = 1;
			break;
		default:
			System.out.println("Invalid food choice.");
			return;
		}

		// Determine drink price
		switch (drinkChoice) {
		case 1:
			drinkName = "Milo";
			drinkPrice = 2;
			break;
		case 2:
			drinkName = "Teh Tarik";
			drinkPrice = 1.50;
			break;
		case 3:
			drinkName = "Air Kosong";
			drinkPrice = 0;
			break;
		default:
			System.out.println("Invalid drink choice.");
			return;
		}

		double total = foodPrice + drinkPrice;
		System.out.printf("You selected %s and %s. Total price is: RM%.2f%n", foodName, drinkName, total);
	}
}
