
import java.util.Scanner;

public class week4que3 {
    public static void main(String[] args) {
        System.out.println("Program to compute sum and product of four Numbers:");
        Scanner sc=new Scanner(System.in);
        int num1,num2,num3,num4,sum,product;
        System.out.print("Enter Number one: ");
        num1=sc.nextInt();
        System.out.print("Enter Number Two: ");
        num2= sc.nextInt();;
        System.out.print("Enter Number three ");
        num3=sc.nextInt();
        System.out.print("Enter Number four: ");
        num4=sc.nextInt();
        sum=num1+num2+num3+num4;
        product=num1*num2*num3*num4;
        System.out.print("Sum and Product of Number is: "+sum+"\t"+product);
        sc.close();
    }
}
