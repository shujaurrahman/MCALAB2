import java.util.Scanner;
public class week3que4 {
    public static void main(String[] args) {
        System.out.println("Program to compute Sum of Even");
        Scanner sc=new Scanner(System.in);
        int sum=0,n;
        System.out.println("Enter N: ");
        n=sc.nextInt();
        for(int i=0;i<=n;i+=2){
            sum+=i;
        }
        System.out.println("Sum of the Series is: "+sum);
        sc.close();
    }
}
