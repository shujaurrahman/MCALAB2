import java.util.Scanner;

public class week4que2 {
    public static void main(String[] args) {
        System.out.println("Program to print possible combination of three Numbers.");
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        System.out.println("Enter three Numbers: ");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        int arr[]={a,b,c};
        System.out.println("Numbers combinations are: ");
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for (int k=0;k<3;k++){
                    if(i!=j && j!=k && k!=i ){
                        System.out.println(arr[i]+""+arr[j]+""+arr[k]+"\t");
                    }
                }
            }
        }
        sc.close();
    }
}
