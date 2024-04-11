package WEEK_7;

import org.apache.log4j.Logger;

public class w7q3 {
    private static final Logger log = Logger.getLogger(w7q3.class);
    public static void main(String[] args) {
        try{
            simulatingRuntimeException();
        } catch(RuntimeException re) {
            System.out.println("Runtime Exception: " + re.getMessage());
            log.error("Runtime Exception: " + re.getMessage());
        }

    }
    public static void simulatingRuntimeException(){
        throw new RuntimeException("Runtime Exception Occurred! Logged in the log file.");
    }
}
