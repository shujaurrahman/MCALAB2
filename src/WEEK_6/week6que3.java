import java.util.Scanner;

public class week6que3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Ask the user which version to execute
        System.out.println("Choose a version to execute:");
        System.out.println("1. Version A (Try-Catch Block)");
        System.out.println("2. Version B (Default Exception Handler)");
        System.out.println("3. Version C (Preventing Unchecked Exceptions)");
        System.out.print("Enter the version number (1, 2, or 3): ");

        int versionChoice = scanner.nextInt();

        switch (versionChoice) {
            case 1:
                versionA(userInput.equals("null") ? null : userInput);
                break;
            case 2:
                versionB(userInput.equals("null") ? null : userInput);
                break;
            case 3:
                versionC(userInput.equals("null") ? null : userInput);
                break;
            default:
                System.err.println("Invalid choice. Please enter 1, 2, or 3.");
        }

        scanner.close();
    }


    // Version A: Using Try-Catch Block
    private static void versionA(String input) {
        try {
            int lengthA = input.length(); // This line will throw a NullPointerException if input is null
            System.out.println("Version A: Length of the string: " + lengthA);
        } catch (NullPointerException e) {
            System.err.println("Version A: Null Pointer Exception caught!");
            System.err.println("Details: " + e.getMessage());
        }
    }

    // Version B: Using Default Exception Handler
    private static void versionB(String input) {
        int lengthB;

        try {
            lengthB = input.length(); // This line will throw a NullPointerException if input is null
            System.out.println("Version B: Length of the string: " + lengthB);
        } catch (NullPointerException e) {
            System.err.println("Version B: Null Pointer Exception caught!");
            System.err.println("Details: " + e.getMessage());
        }
    }

    // Version C: Preventing Unchecked Exceptions
    private static void versionC(String input) {
        if (input != null) {
            int lengthC = input.length(); // This line will not execute if input is null
            System.out.println("Version C: Length of the string: " + lengthC);
        } else {
            System.err.println("Version C: Null Pointer Exception prevented by checking for null!");
        }
    }
}




