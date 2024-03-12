package WEEK_7;

import java.util.Scanner;

public class w7q1 {
    // Original method susceptible to ArithmeticException (division by zero)
    public static double divide(double numerator, double denominator) {
        return numerator /denominator;
    }

    // Robust method with defensive coding techniqes
    public static double safeDivide(double numerator, double denominator) {
        try {
            if (denominator==0) {
                System.out.println("Error: Division by zero is not allowed.");
                return 0;
            }
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception Occurred: " + e.getMessage());
            return 0;
        }
    }
    public static void main(String[] args) {

        double result1 = divide(10, 0);
        System.out.println("Result of divide method: " + result1);

        double result2 = safeDivide(10.0, 0.0);
        System.out.println("Result of safeDivide method: " + result2);

        double result3 = safeDivide(10.0, 5.0);
        System.out.println("Result of safeDivide method: " + result3);
    }
}
