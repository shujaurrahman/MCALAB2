package WEEK_12;
import java.io.*;

public class JavaPreCompiler {
    public static void main(String[] args) {
        String inputFileName = "/Users/shujaurrahman/Desktop/MCA/SEMESTER 2/MCALAB/src/WEEK_12/input.java";
        String outputFileName = "/Users/shujaurrahman/Desktop/MCA/SEMESTER 2/MCALAB/src/WEEK_12/output.java";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                // Replace comments
                line = replaceComments(line);
                // Replace end of statements
                line = replaceEndOfStatement(line);
                // Replace blocks
                line = replaceBlocks(line);

                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Pre-compilation completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String replaceComments(String line) {
        // Replace "$" with "//"
        return line.replaceAll("\\$", "//");
    }

    private static String replaceEndOfStatement(String line) {
        // Replace ";" with desired special character
        return line.replaceAll(";", "\\$"); // Escape the "$" character
    }


    private static String replaceBlocks(String line) {
        // Replace "{" with "[" and "}" with "]"
        return line.replaceAll("\\{", "[").replaceAll("\\}", "]");
    }
}
