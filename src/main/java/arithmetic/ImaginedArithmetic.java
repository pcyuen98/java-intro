package arithmetic;

public class ImaginedArithmetic {

    public static void main(String[] args) {

        // Simulate the variables and their values
        NaturalNumber i1 = new NaturalNumber(12);
        NaturalNumber i2 = new NaturalNumber(23);
        FloatingPointNumber f1 = new FloatingPointNumber(7.23);
        FloatingPointNumber f2 = new FloatingPointNumber(-2.15);

        // Simulate the add operations and print the results
        System.out.println("i1.add(i2) // results in " + i1.add(i2));
        System.out.println("i2.add(f1) // results in " + i2.add(f1));
        System.out.println("f2.add(i1) // results in " + f2.add(i1));
        System.out.println("f1.add(f2) // results in " + f1.add(f2));
    }
}

// Custom class to represent natural numbers
class NaturalNumber {
    private int value;

    public NaturalNumber(int value) {
        this.value = value;
    }

    public double add(NaturalNumber other) {
        return this.value + other.value;
    }

    public double add(FloatingPointNumber other) {
        return this.value + other.getValue();
    }

    public double getValue() {
        return value;
    }
}

// Custom class to represent floating-point numbers
class FloatingPointNumber {
    private double value;

    public FloatingPointNumber(double value) {
        this.value = value;
    }

    public double add(NaturalNumber other) {
        return this.value + other.getValue();
    }

    public double add(FloatingPointNumber other) {
        return this.value + other.getValue();
    }

    public double getValue() {
        return value;
    }
}