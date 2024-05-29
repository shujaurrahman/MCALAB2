package Swing_Playground;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class occurence {
    public static void main(String[] args) {
        String fileName = "your_file_path.txt"; // Specify the path to your text file
        Map<String, Integer> wordCounts = new HashMap<>();
        Map<Character, Integer> charCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    for (char c : word.toCharArray()) {
                        if (Character.isLetter(c)) {
                            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                        }
                    }
                }
            }

            String maxWord = "";
            int maxWordCount = 0;
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                if (entry.getValue() > maxWordCount) {
                    maxWord = entry.getKey();
                    maxWordCount = entry.getValue();
                }
            }

            char maxChar = ' ';
            int maxCharCount = 0;
            for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
                if (entry.getValue() > maxCharCount) {
                    maxChar = entry.getKey();
                    maxCharCount = entry.getValue();
                }
            }

            System.out.println("Word with maximum occurrence: " + maxWord + " (" + maxWordCount + " times)");
            System.out.println("Character with maximum occurrence: " + maxChar + " (" + maxCharCount + " times)");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
