package basic.input.answer;

record DrinkDetails(String name, double price) {}

public class ExerciseBasicFoodWithInputParameterAnswer {
	private static int parseChoice(String[] args, int index, String type) {
		if (args.length <= index) {
			System.out.println("Missing parameter for " + type);
			System.exit(1);
		}
		return Integer.parseInt(args[index]);
	}

	private static DrinkDetails getDrinkDetails(int drinkChoice) {
		String drinkName;
		double drinkPrice;

		switch (drinkChoice) {
			case 1: // Using traditional switch for clarity with variable assignment
				drinkName = "Milo";
				drinkPrice = 2.00;
				break;
			case 2:
				drinkName = "Teh Tarik";
				drinkPrice = 1.50;
				break;
			case 3:
				drinkName = "Air Kosong";
				drinkPrice = 0.00;
				break;
			default:
				// Throw an exception instead of System.exit(1) for better modularity
				throw new IllegalArgumentException("Invalid drink choice: " + drinkChoice);
		}
		// Return a new instance of the DrinkDetails record
		return new DrinkDetails(drinkName, drinkPrice);
	}

	public static void main(String args[]) {
		int foodChoice = parseChoice(args, 0, "food");
		int drinkChoice = parseChoice(args, 1, "drink");

		System.out.println("First Argument = " + args[0]);
		System.out.println("Second Argument = " + args[1]);

		double foodPrice = 0;
		String foodName = "";

		switch (foodChoice) {
		case 1 -> {
			foodName = "McDonald's";
			foodPrice = 10;
		}
		case 2 -> {
			foodName = "Nasi Lemak";
			foodPrice = 2;
		}
		case 3 -> {
			foodName = "Mee Kosong";
			foodPrice = 1;
		}
		default -> {
			System.out.println("Invalid food choice.");
			return;
		}
		}

		DrinkDetails selectedDrink = getDrinkDetails(drinkChoice);

		double total = foodPrice + selectedDrink.price();
		System.out.printf("You selected %s and %s. Total price is: RM%.2f%n", foodName, selectedDrink.name(), total);
	}
}
