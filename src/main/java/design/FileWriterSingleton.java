package design;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton class to write content to a file.
 * <p>
 * Uses double-checked locking and a volatile instance to ensure thread-safe
 * lazy initialization. This ensures only one instance of the file writer logic
 * is used across the application.
 * </p>
 *
 * <p>
 * This pattern is useful for managing shared resources such as file access,
 * logging utilities, configuration readers, and database connections, where
 * having multiple instances could lead to conflicts or inefficiency.
 * </p>
 */
public class FileWriterSingleton {

	// Volatile ensures visibility of changes to variables across threads
	private static volatile FileWriterSingleton instance;

	// Private constructor to prevent instantiation
	private FileWriterSingleton() {
	}

	// Double-checked locking to ensure thread-safe lazy initialization
	public static FileWriterSingleton getInstance() {
		if (instance == null) {
			synchronized (FileWriterSingleton.class) {
				if (instance == null) {
					instance = new FileWriterSingleton();
				}
			}
		}
		return instance;
	}

	// Method to write content to file
	public void writeToFile(String filename, String content) {
		try (FileWriter writer = new FileWriter(filename, true)) { // true = append mode
			writer.write(content + System.lineSeparator());
			System.out.println("Written: " + content);
		} catch (IOException e) {
			System.err.println("File write error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		FileWriterSingleton writer = FileWriterSingleton.getInstance();

		writer.writeToFile("log.txt", "This is a test log entry.");
		writer.writeToFile("log.txt", "Another line from the singleton writer.");
	}
}
