package WEEK_12;

public class input {
    public static void main(String[] args) {
        int x = 10;
        float y = 3.14f;
        String str = "Hello";

        for (int i = 0; i < 5; i++) {
            System.out.println("Inside for loop");
        }

        while (x > 0) {
            System.out.println("Inside while loop");
            x--;
        }

        do {
            System.out.println("Inside do-while loop");
            x--;
        } while (x > 0);

        if (x < 0) {
            System.out.println("X is negative");
        } else {
            System.out.println("X is non-negative");
        }
    }

    public static void anotherMethod() {
        System.out.println("Inside another method");
    }
}
