
import java.util.Scanner;
public class week2que1 {
    public static void main(String[] args) {
        System.out.println("Program to perform Arithmetic Operations on two Numbers.");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First Number: ");
        int num1= sc.nextInt();
        System.out.println("Enter the Second Number: ");
        int num2= sc.nextInt();
        int sum,diff,product,op;
        float div;

        System.out.println("Operation\n 1.Sum \n 2.Subtract \n 3. Product \n 4.Divide \n 5.Min \n 6. Max ");
        System.out.println("Enter Operation: ");
        op=sc.nextInt();
        switch(op){
            case 1:
                sum=num1+num2;
                System.out.println("Sum of two Numbers is: "+sum);
                break;
            case 2:
                diff=num1-num2;
                System.out.println("Difference of two Numbers is: "+diff);
                break;
            case 3:
                product=num1*num2;
                System.out.println("Product of two Numbers is: "+product);
                break;
            case 4:
                if (num2!=0){
                    div=(float)num1/(float)num2;
                    System.out.println(div);
                }else{
                    System.out.println("Division Not Possible");
                }
                break;
            case 5:
                if (num1>num2){
                    System.out.println("Number "+num2+"is Minimum.");
                }else{
                    System.out.println("Number "+num1+"is Minimum");
                }
                break;
            case 6:
                if (num1>num2){
                    System.out.println("Number "+num1+"is Maximum");
                }else{
                    System.out.println("Number "+num2+"is Maximum");
                }
                break;
        }
        sc.close();

    }
}
