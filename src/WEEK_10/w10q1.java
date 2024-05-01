package WEEK_10;
import java.util.ArrayList;

public class w10q1 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("String");
        objects.add(10);
        objects.add(10.5);
        objects.add(true);
        objects.add('c');

        ArrayList<Object> successfullyCasted = new ArrayList<>();

        System.out.println("Attempting type casting:");

        for (Object obj : objects) {
            try {
                if (obj instanceof String) {
                    try {
                        Integer intValue = Integer.parseInt((String) obj);
                        successfullyCasted.add(intValue);
                        System.out.println("Successfully casted String to Integer: " + intValue);
                    } catch (NumberFormatException ex) {
                        System.out.println("Failed to cast String to Integer: " + obj);
                    }
                } else if (obj instanceof Integer) {
                    Double doubleValue = Double.valueOf((Integer) obj);
                    successfullyCasted.add(doubleValue);
                    System.out.println("Successfully casted Integer to Double: " + doubleValue);
                } else if (obj instanceof Double) {
                    Integer intValue = ((Double) obj).intValue();
                    successfullyCasted.add(intValue);
                    System.out.println("Successfully casted Double to Integer: " + intValue);
                } else if (obj instanceof Boolean) {
                    String stringValue = Boolean.toString((Boolean) obj);
                    successfullyCasted.add(stringValue);
                    System.out.println("Successfully casted Boolean to String: " + stringValue);
                } else if (obj instanceof Character) {
                    int intValue = (int) (char) obj;
                    successfullyCasted.add(intValue);
                    System.out.println("Successfully casted Character to Integer: " + intValue);
                } else {
                    // If the object cannot be casted
                    throw new ClassCastException("Cannot cast " + obj.getClass().getSimpleName() + " to desired type.");
                }
            } catch (ClassCastException e) {
                System.out.println("Failed to cast: " + e.getMessage());
            }
        }

        System.out.println("\nSuccessfully casted objects:");
        for (Object obj : successfullyCasted) {
            System.out.println(obj);
        }
        System.out.println("Total count of successfully casted objects: " + successfullyCasted.size());
    }
}
