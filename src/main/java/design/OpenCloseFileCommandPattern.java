package design;

import java.io.File;
import java.io.IOException;

/**
 * Command interface to encapsulate a request as an object.
 * Allows the parameterization of clients with different requests.
 *
 * Advantages of Command Pattern:
 * 1. **Decoupling of sender and receiver**: The invoker doesn't know the details of how a command is executed. 
 * 2. **Flexible command execution**: Commands can be stored, logged, or queued to be executed later. 
 * 3. **Support for undo/redo functionality**: By maintaining a history of executed commands, you can easily implement undo/redo functionality.
 *
 * Disadvantages of Command Pattern:
 * 1. **Increased complexity**: Involving multiple classes (Command, Receiver, Invoker) may add complexity to your code.
 * 2. **Potential for bloated code**: If there are many commands, the code can become bloated, making it harder to manage.
 * 3. **Overhead**: For small applications with simple requirements, the command pattern might add unnecessary overhead.
 */
interface Command {
    void execute();
}

/**
 * Receiver class that contains the actual business logic.
 * It defines methods that can be executed as commands.
 */
class FileHandler {
    private File file;

    public FileHandler(String fileName) {
        file = new File(fileName);
    }

    /** Opens the file (simulated by creating a file object). */
    void open() {
        try {
            if (file.createNewFile()) {
                System.out.println("File opened: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while opening the file.");
            e.printStackTrace();
        }
    }

    /** Closes the file (simulated by doing nothing). */
    void close() {
        System.out.println("File closed: " + file.getName());
    }
}

/**
 * Invoker class that takes a command and executes it.
 * The invoker does not know the details of the command's execution.
 */
class FileInvoker {
    /**
     * Executes the given command.
     *
     * @param command the command to execute
     */
    void submit(Command command) {
        command.execute();
    }
}

/**
 * Client class demonstrating the Command design pattern.
 * It configures the receiver and passes commands to the invoker.
 */
public class OpenCloseFileCommandPattern {
    /**
     * Main method to demonstrate command pattern using lambdas.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("example.txt");
        FileInvoker fileInvoker = new FileInvoker();

        // Passing commands using lambda expressions (functional interface)
        fileInvoker.submit(() -> fileHandler.open());
        fileInvoker.submit(() -> fileHandler.close());
    }
}
