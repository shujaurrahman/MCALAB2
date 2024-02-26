import java.util.Scanner;
public class week1que3 {
    public static void main(String[] args) {
        System.out.println("Program to Add to Numbers. ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1=sc.nextInt();
        System.out.println("Enter Second Number: ");
        int num2= sc.nextInt();
        int sum=num1+num2;
        System.out.println("Sum of two Numbers is : "+sum);
        sc.close();
    }
}
