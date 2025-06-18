package advance.hackerrank;
import java.util.Scanner;

/*Java: Shape
Define the following 2 classes to represent 2-dimensional objects.

Super Class: Shape
It should have

2 member variables: length, and breadth of integer types.
2 argument constructor for length and breadth which stores the arguments in their corresponding member variables.
A method, area(), which prints the length and breadth of the shape, delimited by a space.
Concrete Class: Rectangle
It should have

2 argument constructor for length and breadth. It should forward those arguments to the superclass constructor.
Override the area() method to print the area using the formula (length*breadth).   import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/


class Shape {
    // Member variables to hold length and breadth
    int length;
    int breadth;

    // Constructor to initialize length and breadth
    public Shape(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to print length and breadth
    public void area() {
        System.out.println(length + " " + breadth);
    }
}

class Rectangle extends Shape {

    // Constructor that forwards the length and breadth to the superclass constructor
    public Rectangle(int length, int breadth) {
        super(length, breadth);  // Call the constructor of Shape
    }

    // Override the area() method to calculate and print the area of the rectangle
    @Override
    public void area() {
        int area = length * breadth;
        System.out.println(area);
    }
}

public class ShapeSolution {
    public static void main(String args[]) throws Exception {
        // Read input for length and breadth
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        
        // Create a Rectangle object and pass length and breadth to it
        Rectangle rectangle = new Rectangle(length, breadth);
        
        // Call the area method to print the area
        rectangle.area();
        
        // Close the scanner
        sc.close();
    }
}
