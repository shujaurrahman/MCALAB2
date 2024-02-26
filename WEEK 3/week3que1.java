import java.util.Scanner;
public class week3que1 {
    public static void main(String[] args) {
        System.out.println("Program to Print the count of Even and Odd.");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Ending digit: ");
        int n=sc.nextInt();
        int odd=0,even=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("Number of Even Number till "+n+" are: "+even);
        System.out.println("Number of Odd Number till "+n+" are: "+odd);
    }
}
