
import java.util.Scanner;
public class week3que3 {
    public static void main(String[] args) {
        System.out.println("Program to Compute the Sum of Reciprocals.");
        Scanner sc=new Scanner(System.in);
        float sum=0,n;
        System.out.println("Enter the Value of N: ");
        n=sc.nextFloat();
        for(int i=1;i<=n;i++){
            sum+=1/(float)i;
        }
        System.out.printf("Sum of Reciprocals is: %.3f ",sum);
//        System.out.printf("%.3f",sum);
    }
}
