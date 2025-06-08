package advance.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class to generate a large story-like text file by combining random story fragments.
 */
public class LargeFileGenerator {

    // Target file size: 100 MB
    // private static final long TARGET_FILE_SIZE_BYTES = 1000 * 1024 * 1024;
	 private static final long TARGET_FILE_SIZE_BYTES = 10 * 1024;
    // Sample story fragments
    private static final List<String> STORY_FRAGMENTS = Arrays.asList(
            "Once upon a time in a quiet village,",
            "there lived a curious young girl named Lily.",
            "She loved exploring the nearby forest,",
            "where magical creatures were said to dwell.",
            "One sunny afternoon,",
            "she found a glowing stone beneath an ancient oak tree.",
            "The stone shimmered with a mysterious light,",
            "and when she touched it, the world around her changed.",
            "Suddenly, the forest whispered secrets only she could hear.",
            "Guided by the voices, she embarked on an unforgettable journey.",
            "Through misty valleys and starlit skies,",
            "she met talking animals, flying ships, and shadowy guardians.",
            "Every step took her deeper into the unknown,",
            "until she reached a kingdom lost in time.",
            "There, a forgotten prophecy awaited her.",
            "She was the chosen one, destined to restore balance.",
            "With courage and kindness,",
            "she faced the trials of the enchanted realm.",
            "And in the end,",
            "she returned home, forever changed and full of wonder."
    );

    public static void generateStoryFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        long bytesWritten = 0;
        int bufferSize = 8192;

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toFile()), bufferSize)) {
            while (bytesWritten < TARGET_FILE_SIZE_BYTES) {
                String fragment = STORY_FRAGMENTS.get(ThreadLocalRandom.current().nextInt(STORY_FRAGMENTS.size()));

                // Randomly decide whether to add a period, space, or paragraph break
                String suffix = chooseRandomSuffix();
                String content = fragment + suffix;
                byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);

                if (bytesWritten + contentBytes.length > TARGET_FILE_SIZE_BYTES && bytesWritten > 0) {
                    break;
                }

                bos.write(contentBytes);
                bytesWritten += contentBytes.length;
            }

            System.out.println("Finished writing file: " + filePath);
            System.out.printf("Total bytes written: %d (~%.2f MB)%n", bytesWritten, bytesWritten / (1024.0 * 1024.0));

        } catch (IOException e) {
            System.err.println("Error generating story file: " + e.getMessage());
            throw e;
        }
    }

    private static String chooseRandomSuffix() {
        int choice = ThreadLocalRandom.current().nextInt(100);
        if (choice < 5) return "\n\n";       // paragraph break
        if (choice < 50) return ". ";        // sentence end
        return " ";                          // continuation
    }

    public static void main(String[] args) {
        String fileName = "giant_file1gb.txt";

        try {
            System.out.println("Generating a 100 MB story file: " + fileName);
            generateStoryFile(fileName);
            System.out.println("Story file generation completed.");
        } catch (IOException e) {
            System.err.println("Story file generation failed: " + e.getMessage());
        }
    }
}
