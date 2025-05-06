package basic.input;

/**
 * Demonstrates how to define and use a basic MenuItem class
 * with name and price attributes in Java.
 */
public class ExampleBasicInputFoodClassOnly {

    /**
     * Represents a food or drink item with a name and price.
     */
    static class MenuItem {
        String name;
        double price;

        /**
         * Constructs a MenuItem with a given name and price.
         *
         * @param name  The name of the menu item.
         * @param price The price of the menu item.
         */
        MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    /**
     * Main method to demonstrate creating and displaying a MenuItem.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // initialize the MenuItem and display it
        MenuItem item = new MenuItem("Roti Canai", 1.20);
        System.out.println("Item: " + item.name + ", Price: RM" + item.price);
    }
}
