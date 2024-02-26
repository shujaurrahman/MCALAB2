import java.util.Scanner;
public class week1que2 {
    public static void main(String[] args) {
        System.out.println("Program to Print Address of User.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the House Number of Your Address: ");
        String housenumber = sc.nextLine();
        System.out.println("Enter the Street Name of Your Address: ");
        String street = sc.nextLine();
        System.out.println("Enter the City/District of Your Address");
        String city = sc.nextLine();
        System.out.println("Enter the Country of Your Address: ");
        String country = sc.nextLine();

        System.out.print("Address is: " + housenumber + "\n" + street + "\n" + city + "\n" + country);
        sc.close();

    }
}
