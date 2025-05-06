package basic.input;

import java.util.Scanner;

public class ExampleBasicInputFoodWithValidation {

    static class MenuItem {
        String name;
        double price;

        MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static final MenuItem[] foodMenu = {
        new MenuItem("McDonald's", 10),
        new MenuItem("Nasi Lemak", 2),
        new MenuItem("Mee Kosong", 1)
    };

    static final MenuItem[] drinkMenu = {
        new MenuItem("Milo", 2),
        new MenuItem("Teh Tarik", 1.50),
        new MenuItem("Air Kosong", 0)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodChoice = getUserChoice(scanner, "Food Menu", foodMenu);
        if (!validateChoice(foodChoice, foodMenu.length)) return;

        int drinkChoice = getUserChoice(scanner, "Drink Menu", drinkMenu);
        if (!validateChoice(drinkChoice, drinkMenu.length)) return;

        MenuItem food = foodMenu[foodChoice];
        MenuItem drink = drinkMenu[drinkChoice];
        double total = food.price + drink.price;

        System.out.printf("You selected %s and %s. Total price is: RM%.2f%n", food.name, drink.name, total);
    }

    static int getUserChoice(Scanner scanner, String title, MenuItem[] menu) {
        System.out.println(title + ":");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s - RM%.2f%n", i + 1, menu[i].name, menu[i].price);
        }
        System.out.print("Enter your choice (1-" + menu.length + "): ");
        int choice = scanner.nextInt();
        return choice - 1; // zero-based index
    }

    static boolean validateChoice(int index, int menuLength) {
        if (index < 0 || index >= menuLength) {
            System.out.println("Invalid choice. Please try again.");
            return false;
        }
        return true;
    }
}
