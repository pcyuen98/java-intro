package util;

import java.io.IOException;

public class PressAnyKey {

	public static void run() {

		System.out.println("Press any key to continue...");
		try {
			System.in.read(); // Read a single byte (any key press)

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Continuing...");

	}
}
