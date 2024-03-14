package WEEK_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Custom exception class for file input-related issues
class FileInputException extends Exception {
    public FileInputException(String message) {
        super(message);
    }
}

public class w9q1 {
    public static void main(String[] args) {
        String fileName = "nonexistent.txt"; // Does not exist

        try {
            readFromFile(fileName);
        } catch (FileInputException e) {
            System.err.println("Custom file input exception: " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName) throws FileInputException {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            // Perform file reading operations here
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line
                System.out.println(line);
            }

        } catch (IOException e) {
            // Throwing custom exception instead of FileNotFoundException
            throw new FileInputException("Error reading from file: " + e.getMessage());

        } finally {
            // Log a message indicating the successful closure of the FileReader object
            System.out.println("FileReader object closed successfully.");
        }
    }
}

