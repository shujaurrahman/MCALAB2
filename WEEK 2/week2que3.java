
//import java.lang.Math;
import java.util.Scanner;
public class week2que3 {
    public static void main(String[] args) {
        System.out.println("Perform Maths Action on Number.");
        Scanner sc=new Scanner(System.in);
        double num;
        int op;
        System.out.println("Enter Number: ");
        num=sc.nextDouble();
        System.out.println("Enter 1-6 any Number for any Random Operation to of Math class to be Performed.");
        System.out.println("Enter operation: ");
        op=sc.nextInt();
        switch (op){
            case 1:
                System.out.println("Round Value of Number is: "+Math.round(num));
                break;
            case 2:
                System.out.println("Ceil Value of Number is: "+Math.ceil(num));
                break;
            case 3:
                System.out.println("Square root Value of Number is: "+Math.sqrt(num));
                break;
            case 4:
                System.out.println("Absolute Value of Number is: "+Math.abs(num));
                break;
            case 5:
                System.out.println("Exponent Value of Number is: "+Math.exp(num));
                break;
            case 6:
                System.out.println("Cube Root Value of Number is: "+Math.cbrt(num));
                break;

            default:
                System.out.println("No valid Operation Selected");
        }

    }
}
