package design.factory;

import java.io.File;
import java.io.IOException;

interface Command {
    void execute();
}

/**
 * Design Pattern Justification: Command Pattern vs Factory Pattern
 *
 * ✅ Why the Command Pattern is More Suitable:
 * The Command Pattern encapsulates a request (e.g., file operations like open or close) as an object.
 * It allows the decoupling of the sender (Invoker) from the receiver (FileHandler), and supports
 * parameterization, logging, queuing, and deferred execution.
 *
 * In this implementation:
 * - Actions such as `open` and `close` are executed on a FileHandler instance.
 * - Lambda expressions (or concrete Command classes) are passed to a FileInvoker.
 * - The focus is on executing operations dynamically and flexibly.
 *
 * Key benefits:
 * - The invoker (`FileInvoker`) does not need to know the details of the command's implementation.
 * - Supports easy extensibility for features like undo, macro commands, or history tracking.
 * - Clean separation of when and how commands are executed.
 *
 * ❌ Why the Factory Pattern Alone Would Be Less Appropriate:
 * The Factory Pattern is primarily used to create objects without exposing the creation logic.
 * In contrast, this scenario is about executing behavior, not object creation.
 *
 * Using only the Factory Pattern:
 * - Would allow abstraction of Command instantiation.
 * - But it does not encapsulate the behavior itself.
 * - This limits flexibility and decoupling, especially if commands need to be executed dynamically.
 *
 * ✅ When to Use the Factory Pattern Alongside the Command Pattern:
 * If the application grows to include many command types (e.g., open, close, delete, rename),
 * the Factory Pattern can help instantiate the correct Command object based on input.
 *
 * Example:
 * <pre>
 *     CommandFactory factory = CommandRegistry.get("open");
 *     Command cmd = factory.create(fileHandler);
 *     invoker.submit(cmd);
 * </pre>
 * In this case, the Factory creates the command, and the Command Pattern handles execution logic.
 *
 * ✅ Summary:
 * <table border="1">
 *   <tr><th>Design Pattern</th><th>Use Case</th><th>Fit</th></tr>
 *   <tr><td>Command Pattern</td><td>Encapsulate actions (open/close) to execute later</td><td>✅ Best fit</td></tr>
 *   <tr><td>Factory Pattern</td><td>Create objects (like Command objects) dynamically</td><td>⚠️ Optional helper</td></tr>
 *   <tr><td>Together</td><td>Factory creates commands, Command encapsulates logic</td><td>✅ Scalable</td></tr>
 * </table>
 */

class FileHandler {
    private static volatile FileHandler instance;
    private File file;

    private FileHandler(String fileName) {
        file = new File(fileName);
    }

    public static FileHandler getInstance(String fileName) {
        if (instance == null) {
            synchronized (FileHandler.class) {
                if (instance == null) {
                    instance = new FileHandler(fileName);
                }
            }
        }
        return instance;
    }

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

    void close() {
        System.out.println("File closed: " + file.getName());
    }
}

// Command for opening a file (OS-specific)
class OpenFileCommand implements Command {
    private final FileHandler fileHandler;

    OpenFileCommand(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        fileHandler.open();
    }
}

// Command for closing a file
class CloseFileCommand implements Command {
    private final FileHandler fileHandler;

    CloseFileCommand(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        fileHandler.close();
    }
}

// Abstract Factory Interface
interface FileCommandFactory {
    Command createOpenCommand();
    Command createCloseCommand();
}

// Concrete Factory for Windows
class WindowsFileCommandFactory implements FileCommandFactory {
    private final FileHandler fileHandler;

    WindowsFileCommandFactory(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public Command createOpenCommand() {
        System.out.println("[Windows] Using Windows-specific logic...");
        return new OpenFileCommand(fileHandler);
    }

    public Command createCloseCommand() {
        return new CloseFileCommand(fileHandler);
    }
}

// Concrete Factory for Linux
class LinuxFileCommandFactory implements FileCommandFactory {
    private final FileHandler fileHandler;

    LinuxFileCommandFactory(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public Command createOpenCommand() {
        System.out.println("[Linux] Using Linux-specific logic...");
        return new OpenFileCommand(fileHandler);
    }

    public Command createCloseCommand() {
        return new CloseFileCommand(fileHandler);
    }
}

class FileInvoker {
    void submit(Command command) {
        command.execute();
    }
}

public class OpenCloseFileFactoryPatternExercise {
    public static void main(String[] args) {
        FileHandler fileHandler = FileHandler.getInstance("example.txt");
        FileInvoker fileInvoker = new FileInvoker();

        // Choose factory based on OS (simple demo switch here)
        String os = System.getProperty("os.name").toLowerCase();
        FileCommandFactory factory = os.contains("win")
                ? new WindowsFileCommandFactory(fileHandler)
                : new LinuxFileCommandFactory(fileHandler);

        // Use command pattern through factory
        fileInvoker.submit(factory.createOpenCommand());
        fileInvoker.submit(factory.createCloseCommand());
    }
}
