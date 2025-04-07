package advance;

import java.util.ArrayList;
import java.util.Comparator;

// Define a Car class
class ComparatorCar {
    private String brand;
    private String model;
    private int year;

    public ComparatorCar(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + year;
    }


public static void main(String[] args) {
    // Create a list of cars
    ArrayList<ComparatorCar> myCars = new ArrayList<>();
    myCars.add(new ComparatorCar("BMW", "X5", 1999));
    myCars.add(new ComparatorCar("Honda", "Accord", 2006));
    myCars.add(new ComparatorCar("Ford", "Mustang", 1970));

    // Sort cars by year using lambda
    myCars.sort(Comparator.comparingInt(ComparatorCar::getYear));

    // Display the sorted cars
    myCars.forEach(System.out::println);
}
}