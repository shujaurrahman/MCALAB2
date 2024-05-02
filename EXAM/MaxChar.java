package Swing_Playground;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaxChar {
    public static void main(String[] args) {
        String filename = "/Users/apple/Desktop/Study File/Codarea/Java/Swing_Playground/resources/password.txt"; // Replace with the path to your file

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Count occurrences of characters
            Map<Character, Integer> charCounts = new HashMap<>();
            for (char c : content.toString().toCharArray()) {
                if (Character.isLetter(c)) {
                    charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                }
            }

            // Find character with maximum occurrences
            int maxCharCount = 0;
            char maxChar = '\0'; // Placeholder for character with maximum occurrences
            for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
                if (entry.getValue() > maxCharCount) {
                    maxCharCount = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            // Count occurrences of words
            Map<String, Integer> wordCounts = new HashMap<>();
            String[] words = content.toString().split("\\s+");
            for (String word : words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            // Find word with maximum occurrences
            int maxWordCount = 0;
            String maxWord = null; // Placeholder for word with maximum occurrences
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                if (entry.getValue() > maxWordCount) {
                    maxWordCount = entry.getValue();
                    maxWord = entry.getKey();
                }
            }

            // Print results
            System.out.println("Character with maximum occurrences: " + maxChar + " (" + maxCharCount + " occurrences)");
            System.out.println("Word with maximum occurrences: " + maxWord + " (" + maxWordCount + " occurrences)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

