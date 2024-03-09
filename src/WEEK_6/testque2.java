public class testque2 {

        public static void main(String[] args) {
            try {
                int result = 10 / 0; // ArithmeticException
            } catch (Exception e) {
                System.out.println("Caught an exception");
            }
        }
    
}
