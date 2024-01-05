package WEEK_9;
import java.util.ArrayList;
import java.util.List;
public class w9q3 {
    public static void main(String[] args) {
        // Create an array or list of strings containing both valid and invalid representations of integers
        String[] stringsToConvert = {"123", "456", "789", "abc", "987", "def", "4567"};

        // List to store successfully converted integers
        List<Integer> convertedIntegers = new ArrayList<>();

        // Counter for successfully converted integers
        int successCount = 0;

        // Attempt conversion for each string in the array
        for (String str : stringsToConvert) {
            try {
                // Convert string to integer inside a try-catch block
                int convertedInt = Integer.parseInt(str);
                convertedIntegers.add(convertedInt);
                successCount++;
            } catch (NumberFormatException e) {
                // Handle NumberFormatException and print appropriate error message
                System.out.println("Error converting \"" + str + "\" to an integer: " + e.getMessage());
            }
        }

        // Display successfully converted integers along with total count
        System.out.println("Successfully converted integers:");
        for (int num : convertedIntegers) {
            System.out.println(num);
        }
        System.out.println("Total count of successfully converted integers: " + successCount);
    }
}
