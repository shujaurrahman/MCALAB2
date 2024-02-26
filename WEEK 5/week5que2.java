import java.util.Scanner;

class Circle {
    private double radius;
    private double centerX;
    private double centerY;

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isPointInsideCircle(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return distance <= radius;
    }
}

public class week5que2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the radius of the circle (negative to exit): ");
            double radius = scanner.nextDouble();

            if (radius < 0) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            System.out.print("Enter the x-coordinate of the center: ");
            double centerX = scanner.nextDouble();

            System.out.print("Enter the y-coordinate of the center: ");
            double centerY = scanner.nextDouble();

            Circle circle = new Circle(radius, centerX, centerY);

            System.out.println("Circle Information:");
            System.out.println("Area: " + circle.computeArea());
            System.out.println("Perimeter: " + circle.computePerimeter());

            System.out.print("Enter a point's x-coordinate: ");
            double pointX = scanner.nextDouble();

            System.out.print("Enter a point's y-coordinate: ");
            double pointY = scanner.nextDouble();

            boolean isInside = circle.isPointInsideCircle(pointX, pointY);

            if (isInside) {
                System.out.println("The point is inside the circle.");
            } else {
                System.out.println("The point is outside the circle.");
            }

            System.out.println("-----------------------");
        }

        scanner.close();
    }
}

