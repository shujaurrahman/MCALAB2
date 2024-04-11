package WEEK_7;
import org.apache.log4j.Logger;
import java.io.*;
public class w7q2 {
    private static final Logger log = Logger.getLogger(w7q2.class);
        public static void main(String[] args) {
            try {
                String fileName = "x.txt";
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            } catch (FileNotFoundException f) {
                // Logging error message using logger's object log
                log.error("File not found:" + f.getMessage());

                System.out.print("File not found error: " + f.getMessage());
            } catch (IOException e) {
                // Logging error message using logger's object log
                log.error("File not found:" + e.getMessage());
                System.out.println("IOException: " + e.getMessage());
            } finally {
                System.out.println("Operation Complete!");
            }
        }
}
