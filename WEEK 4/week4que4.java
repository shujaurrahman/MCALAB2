
import java.util.Scanner;

public class week4que4 {
    public static void main(String[] args) {
        int num,revnum=0;
        System.out.println("Program to print four digit number line by line.");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter four digit Number: ");
        num=sc.nextInt();

        while(num>0){
            int r=num%10;
            revnum=revnum*10+r;
            num/=10;
        }
        System.out.println("Digit of Number line by line are: ");
        while(revnum>0){
            int r=revnum%10;
            revnum/=10;
            System.out.println(r);
        }
    }
}
