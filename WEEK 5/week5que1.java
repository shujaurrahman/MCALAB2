import java.util.Scanner;
class OddAndEven {
    private int countOfOdd;
    private int countOfEven;

    public OddAndEven() {
        countOfOdd = 0;
        countOfEven = 0;
    }

    public void addNumber(int number) {
        if (number % 2 == 0) {
            countOfEven++;
        } else {
            countOfOdd++;
        }
    }

    public int getCountOfOdd() {
        return countOfOdd;
    }

    public int getCountOfEven() {
        return countOfEven;
    }

    public String toString() {
        return "Number of Odd: " + countOfOdd + ", Number of Even: " + countOfEven;
    }
}

public class week5que1 {
    public static void main(String[] args) {
        OddAndEven oddAndEvenCounter = new OddAndEven();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (type 'Q' to quit):");

        while (true) {
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                oddAndEvenCounter.addNumber(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'Q' to quit.");
            }
        }

        scanner.close();

        // Display the result
        System.out.println(oddAndEvenCounter.toString());
    }
}

