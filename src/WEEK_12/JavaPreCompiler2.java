package WEEK_12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPreCompiler2 {
    public static void main(String[] args) {
        String fileName = "/Users/shujaurrahman/Desktop/MCA/SEMESTER 2/MCALAB/src/WEEK_12/input.java"; // Replace with the path to your Java file

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int integerCount = 0;
            int floatCount = 0;
            int stringCount = 0;
            int forLoopCount = 0;
            int whileLoopCount = 0;
            int doWhileLoopCount = 0;
            int conditionalStatementCount = 0;
            int methodCount = 0;

            while ((line = reader.readLine()) != null) {
                // Count variables
                integerCount += countOccurrences(line, "\\bint\\b");
                floatCount += countOccurrences(line, "\\bfloat\\b");
                stringCount += countOccurrences(line, "\\bString\\b");

                // Count loops
                forLoopCount += countOccurrences(line, "\\bfor\\b");
                whileLoopCount += countOccurrences(line, "\\bwhile\\b");
                doWhileLoopCount += countOccurrences(line, "\\bdo\\b");

                // Count conditional statements
                conditionalStatementCount += countOccurrences(line, "\\bif\\b");
                conditionalStatementCount += countOccurrences(line, "\\belse\\b");

                // Count methods
                methodCount += countOccurrences(line, "\\bvoid\\s+\\w+\\s*\\(.*\\)\\s*\\{");
            }

            reader.close();

            // Output counts
            System.out.println("Integer variables count: " + integerCount);
            System.out.println("Float variables count: " + floatCount);
            System.out.println("String variables count: " + stringCount);
            System.out.println("For loops count: " + forLoopCount);
            System.out.println("While loops count: " + whileLoopCount);
            System.out.println("Do-while loops count: " + doWhileLoopCount);
            System.out.println("Conditional statements count: " + conditionalStatementCount);
            System.out.println("User-defined methods count: " + methodCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countOccurrences(String line, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }
}
