package advance.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom; // For efficient random number generation

/**
 * Utility class to generate a large text file containing various fruit names.
 */
public class LargeFileGenerator {

    // Target file size: 100 MB
    private static final long TARGET_FILE_SIZE_BYTES = 100 * 1024 * 1024; // 100 * 1 MB in bytes

    // List of 5 different fruits, including apple and orange
    private static final List<String> FRUITS = Arrays.asList(
            "apple", "orange", "banana", "grape", "strawberry"
    );

    /**
     * Generates a large text file populated with random fruit names.
     * The file size will be approximately the target size.
     *
     * @param filePath The path where the file will be created.
     * @throws IOException If an I/O error occurs during file creation or writing.
     */
    public static void generateFruitFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        // Ensure the directory exists
        // If filePath is just a filename, getParent() will return null.
        // Files.createDirectories expects a Path for a directory.
        // So, we only try to create parent directories if path has one.
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }


        long bytesWritten = 0;
        int bufferSize = 1024 * 8; // 8 KB buffer for efficient writing

        // Using try-with-resources to ensure the stream is closed automatically
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toFile()), bufferSize)) {
            while (bytesWritten < TARGET_FILE_SIZE_BYTES) {
                // Get a random fruit from the list
                String randomFruit = FRUITS.get(ThreadLocalRandom.current().nextInt(FRUITS.size()));

                // Add a newline character to separate fruits
                String content = randomFruit + System.lineSeparator();
                byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);

                // If adding the next piece of content would exceed the target,
                // just write a partial piece or break. This ensures it's close to 100MB
                // but not significantly over if the last piece is large.
                if (bytesWritten + contentBytes.length > TARGET_FILE_SIZE_BYTES && bytesWritten > 0) {
                     // Optionally, write only the remaining bytes if needed for exact size,
                     // but for "approximately 100MB", writing full chunks is fine.
                     break; // Stop if the next write would push us significantly over
                }

                bos.write(contentBytes);
                bytesWritten += contentBytes.length;
            }
            System.out.println("Finished writing file: " + filePath);
            System.out.println("Total bytes written: " + bytesWritten + " (~" + (bytesWritten / (1024.0 * 1024.0)) + " MB)");

        } catch (IOException e) {
            System.err.println("Error generating file: " + e.getMessage());
            // Re-throw the exception after logging
            throw e;
        }
    }

    public static void main(String[] args) {
        String fileName = "fruits_100mb.txt";
        // Removed outputPath. The file will be created in the current working directory.
        String fullFilePath = fileName; // File will be created directly in the current directory

        try {
            System.out.println("Attempting to generate a 100 MB file: " + fullFilePath);
            // Changed generateFruitFile(fileName) to generateFruitFile(fullFilePath) for consistency.
            generateFruitFile(fullFilePath);
            System.out.println("File generation completed successfully.");
        } catch (IOException e) {
            System.err.println("File generation failed: " + e.getMessage());
        }
    }
}

