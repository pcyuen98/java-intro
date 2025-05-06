package basic.input;

public class ExampleBasicInputFoodArrayClass {

	static class MenuItem {
		String name;
		double price;

		MenuItem(String name, double price) {
			this.name = name;
			this.price = price;
		}
	}

	/**
	 * Displays the selected menu item using direct index access.
	 */
	static void displayMenu(int choice, MenuItem[] menuitem) {
		MenuItem food = menuitem[choice];
		System.out.printf("You have input %s and RM%.2f.%n", food.name, food.price);
	}

	/**
	 * Displays the full menu using a loop and marks the selected item.
	 */
	static void displayMenuUsingLoop(int choice, MenuItem[] menuitem) {
		System.out.println("Food Menu:");
		for (int i = 0; i < menuitem.length; i++) {
			// do this output this without AI
			// 1. McDonald's - RM10.00
			// 2. Nasi Lemak - RM2.00
			// 3. Mee Kosong - RM1.00
		}
	}

	public static void main(String[] args) {
		MenuItem[] foodMenu = { new MenuItem("McDonald's", 10), new MenuItem("Nasi Lemak", 2),
				new MenuItem("Mee Kosong", 1) };

		int choice = 1; // simulate user selecting option 2 (index 1)

		displayMenu(choice, foodMenu);
		displayMenuUsingLoop(choice, foodMenu);
	}
}
