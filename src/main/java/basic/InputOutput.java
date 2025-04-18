package basic;

import java.util.Scanner;

public class InputOutput {
	
	public static void main(String[] args) {

		// Why there is a error here
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Some value: ");
		int inputValue = scanner.nextInt();
		
		System.out.println("Your Output =>" + inputValue);
	}
}