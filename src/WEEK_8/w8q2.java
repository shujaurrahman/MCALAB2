package WEEK_8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateParsingException extends RuntimeException {
    public DateParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class w8q2 {

    public static void main(String[] args) {
        String dateString = "04/10-2024"; // Replace with an incorrectly formatted date

        // Declare the SimpleDateFormat outside the try block
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Use try-with-resources with SimpleDateFormat
            try {
                Date parsedDate = dateFormat.parse(dateString);
                System.out.println("Parsed Date: " + parsedDate);
            } catch (Exception e) {
                // Throw a custom exception for date parsing-related issues
                throw new DateParsingException("Error parsing the date", e);
            }
        } catch (DateParsingException e) {
            // Catch and handle the custom exception
            System.err.println("Custom Exception: " + e.getMessage());
        } finally {
            // Manually set SimpleDateFormat to null in the finally block
            dateFormat = null;
        }
    }
}
