import java.util.Scanner;

class Commission {
    private double sale;

    // Constructor
    public Commission(double sale) {
        this.sale = sale;
    }

    // Method to calculate commission
    public double calculateCommission() {
        if (sale < 0) {
            System.out.println("Invalid Input");
            return 0; // Return 0 for invalid input
        } else if (sale < 500) {
            return 0.02 * sale; // 2% commission for sales under ₹500
        } else if (sale <= 5000) {
            return 0.05 * sale; // 5% commission for sales between ₹500 and ₹5000
        } else {
            return 0.08 * sale; // 8% commission for sales ₹5000 and above
        }
    }
}

public class week5que4 {
    public static void main(String[] args) {
        // Read sale from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sale amount: ₹");

        // Validate and create Commission object
        double sale = scanner.nextDouble();
        Commission commissionObj = new Commission(sale);

        // Call the commission() method to get and print the commission
        double commission = commissionObj.calculateCommission();
        System.out.println("Commission: ₹" + commission);

        scanner.close();
    }
}
