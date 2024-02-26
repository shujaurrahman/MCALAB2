import java.awt.Rectangle;
import java.util.Scanner;
public class week4que5 {
    public static void main(String[] args) {
        System.out.println("Rectangle Intersection Questions: ");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for the first rectangle (a, b, c, d): ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        Rectangle r1 = new Rectangle(a, b, c, d);
        System.out.println("Rectangle 1: " + r1);

        System.out.println("Enter coordinates for the second rectangle (e, f, g, h): ");
        int e = sc.nextInt();
        int f = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        Rectangle r2 = new Rectangle(e, f, g, h);
        System.out.println("Rectangle 2: " + r2);

        Rectangle intersected = r1.intersection(r2);

        if (intersected.isEmpty()) {
            System.out.println("The rectangles do not intersect.");
        } else {
            System.out.println("Intersection of rectangles: " + intersected);

        }
    }
}
