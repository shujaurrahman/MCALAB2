import java.util.Scanner;
public class week1que4 {
    public static void main(String[] args) {
        System.out.println("Program to Convert Fahrenheit to Celsius.");
        int f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Temp in Fahrenheit: ");
        f=sc.nextInt();
        double c=f-32/1.8;
        System.out.println("Fahrenheit Temp"+"          "+"Celsius Temp");
        System.out.println("-------------------------------------------");
        System.out.println(f+"                       "+c);
        System.out.println(""+c);
        sc.close();
    }
}
