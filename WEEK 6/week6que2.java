import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class week6que2 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java week6que2 <Test java file name here>");
            System.exit(1);
        }

        String filePath = args[0];

        try {
            int exceptionCount = countExceptions(filePath);
            System.out.println("Total number of exceptions: " + exceptionCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to count occurrences of exception-related keywords or patterns
    public static int countExceptions(String filePath) throws IOException {
        int exceptionCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                exceptionCount += countMatches(line, "throws|catch|try|finally|throw|throws");
            }
        }

        return exceptionCount;
    }

    // Helper method to count occurrences of a pattern in a string
    private static int countMatches(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        
        int count = 0;
        while (m.find()) {
            count++;
        }

        return count;
    }
}

