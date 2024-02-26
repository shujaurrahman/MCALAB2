
import java.util.Scanner;

public class week2que2 {
    public static void main(String[] args) {
        System.out.println("Perform Maths Action on Number.");
        Scanner sc=new Scanner(System.in);
        double num,numRound,numCeil,numFloor;
        int op;
        System.out.println("Enter Number: ");
        num=sc.nextDouble();
        System.out.println("Actions: \n 1.Round Value \n 2.Ceil Value \n 3.Floor Value \n");
        System.out.println("Enter operation: ");
        op=sc.nextInt();
        switch (op){
            case 1:
                numRound=Math.round(num);
                System.out.println("Round Value of Number is: "+numRound);
                break;
            case 2:
                numCeil=Math.ceil(num);
                System.out.println("Ceil Value of Number is: "+numCeil);
                break;
            case 3:
                numFloor= Math.floor(num);
                System.out.println("Floor Value of Number is: "+numFloor);
                break;
        }

    }
}
