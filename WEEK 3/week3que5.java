import java.util.Scanner;
public class week3que5 {
    public static void main(String[] args) {
         System.out.println("Program to Print Floyd's Triangle. ");
         Scanner sc=new Scanner(System.in);
         int n,k=1,op;
        System.out.println("Select Pattern to be Printed : ");
        System.out.println("1. Simple Floyd Pattern");
        System.out.println("2. Binary Floyd Pattern");
        System.out.println("Enter Choice: ");
        op= sc.nextInt();
        switch (op) {
            case 1: {
                System.out.println("Enter N [No of Rows]: ");
                n=sc.nextInt();
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < i; j++) {
                        System.out.print(k + " ");
                        k++;
                    }
                    System.out.println();
                }
                break;
            }
            case 2: {
                System.out.println("Enter N [No of Rows]: ");
                n=sc.nextInt();
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < i; j++) {
                        if ((i + j) % 2 == 0) {
                            System.out.print(1);
                        } else {
                            System.out.println(0);
                        }
                    }
                    System.out.println();
                }
                break;
            }
            default:
                System.out.println("Invalid Choice.");
        }
        sc.close();
    }
}
