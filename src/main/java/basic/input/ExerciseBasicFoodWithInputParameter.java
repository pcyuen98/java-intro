package basic.input;

// Exercise to run program from the command prompt
// go to D:\workspace\java-intro\src\main\java folder
// Compile the program - javac basic\input\ExerciseBasicFoodWithInputParameter
// Run the program - java basic.input.ExerciseBasicFoodWithInputParameter 1 1
// Expected Result
// You selected McDonald's and Teh Tarik. Total price is: RM11.50

// or Run from Eclipse. 
// 1. Run As --> Run Configurations
// 2. Click on arguements tab
// 3. key in 1 1 
// 4. Click apply and run
public class ExerciseBasicFoodWithInputParameter {

	private static int parseChoice(String[] args, int index, String type) {
		if (args.length <= index) {
			System.out.println("Missing parameter for " + type);
			System.exit(1);
		}

		return Integer.parseInt(args[index]);
	}

	public static void main(String args[]) {

		int foodChoice = parseChoice(args, 0, "food");
		int drinkChoice = parseChoice(args, 1, "drink");

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
