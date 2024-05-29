package Swing_Playground;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class filehandlingsess {
    public static void main(String[] args) {
        String fileName = "/Users/shujaurrahman/Desktop/Sessional/file.txt"; // Change this to your file name
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Map<Character, Integer> charCount = new HashMap<>();
            Map<String, Integer> wordCount = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                // Count characters
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                    }
                }
                // Count words
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();

            // Find character with maximum occurrence
            char maxChar = ' ';
            int maxCharCount = 0;
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > maxCharCount) {
                    maxChar = entry.getKey();
                    maxCharCount = entry.getValue();
                }
            }

            // Find word with maximum occurrence
            String maxWord = "";
            int maxWordCount = 0;
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                if (entry.getValue() > maxWordCount) {
                    maxWord = entry.getKey();
                    maxWordCount = entry.getValue();
                }
            }

            System.out.println("Character with maximum occurrence: " + maxChar + " (" + maxCharCount + " times)");
            System.out.println("Word with maximum occurrence: " + maxWord + " (" + maxWordCount + " times)");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
