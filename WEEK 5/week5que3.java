import java.util.StringTokenizer;
import java.util.Scanner;

public class week5que3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the text
        System.out.println("Enter text (press Enter twice to finish):");
        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            text.append(line).append("\n");
        }

        // Analyze the text
        int wordCount = countWords(text.toString());
        int sentenceCount = countSentences(text.toString());
        int eCount = countLetterOccurrences(text.toString(), 'e');
        int zCount = countLetterOccurrences(text.toString(), 'z');

        // Print the results
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Number of occurrences of 'e': " + eCount);
        System.out.println("Number of occurrences of 'z': " + zCount);

        scanner.close();
    }

    private static int countWords(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        return tokenizer.countTokens();
    }

    private static int countSentences(String text) {
        // Assuming that a sentence ends with a period, exclamation mark, or question mark
        StringTokenizer tokenizer = new StringTokenizer(text, ".!?");

        // The count will be the total tokens minus 1 (to exclude the last token after the last period)
        return Math.max(tokenizer.countTokens() - 1, 0);
    }

    private static int countLetterOccurrences(String text, char letter) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(letter)) {
                count++;
            }
        }
        return count;
    }
}

