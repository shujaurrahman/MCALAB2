import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Custom exception for invalid data
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

// DataProcessor class to handle file processing and data validation
class DataProcessor {
    
// Method to read numeric values from a text file
public List<Double> readValuesFromFile(String filePath) throws FileNotFoundException, IOException, InvalidDataException {
    List<Double> values = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                double numericValue = Double.parseDouble(line);
                values.add(numericValue);
            } catch (NumberFormatException e) {
                // Handle invalid numeric data
                throw new InvalidDataException("Invalid numeric value in the file");
            }
        }
    }

    return values;
}


    // Method to validate the read numeric values
    public void validateData(List<Double> values) throws InvalidDataException {
        if (values.isEmpty()) {
            throw new InvalidDataException("No valid numeric values found");
        }
    }

    // Method to calculate the average of valid numeric values
    public double calculateAverage(List<Double> validValues) {
        double sum = 0;

        for (double value : validValues) {
            sum += value;
        }

        return sum / validValues.size();
    }

    // Method to write the calculated average to another text file
    public void writeResultToFile(double average, String outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("Average: " + average);
        }
    }
}

public class week6que1 {
    public static void main(String[] args) {
        // Specify input and output file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Instantiate DataProcessor
        DataProcessor dataProcessor = new DataProcessor();

        try {
            // Step 1: Read values from the file
            List<Double> values = dataProcessor.readValuesFromFile(inputFilePath);

            // Step 2: Validate the read data
            dataProcessor.validateData(values);

            // Step 3: Calculate the average
            double average = dataProcessor.calculateAverage(values);

            // Step 4: Write result to another file
            dataProcessor.writeResultToFile(average, outputFilePath);

            System.out.println("Average calculation successful. Check the output file.");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.err.println("Invalid Data: " + e.getMessage());
        }
    }
}
