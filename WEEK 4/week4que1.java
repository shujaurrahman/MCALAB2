
import java.util.Scanner;

public class week4que1 {
    public static void main(String[] args) {
        System.out.println("Program to print Fib Series till N using do-while loop: ");
        int f1=0,f2=1,next,n,i=0;
        System.out.print("Enter N {till N fib Series will be printed}: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("Fib Series till "+n+" is: ");
        System.out.print(f1+"\t"+f2+"\t");
        do{
            next=f1+f2;
            System.out.print(next+"\t");
            f1=f2;
            f2=next;
            i++;
        }while (i<n);
    }
}
