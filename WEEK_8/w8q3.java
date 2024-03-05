package WEEK_8;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
// Custom exception class for network connection issues
class NetworkConnectionException extends Exception {
    public NetworkConnectionException(String message) {
        super(message);
    }
}

// Wrapper class implementing AutoCloseable for HttpURLConnection
record ConnectionWrapper(HttpURLConnection connection) implements AutoCloseable {
    private static final Logger logger = LogManager.getLogger(ConnectionWrapper.class);

    @Override
    public void close() {
        // Close the HttpURLConnection
        if (connection != null) {
            connection.disconnect();
            // Log a message indicating the successful closure using Log4j
            logger.info("HttpURLConnection closed successfully.");
        }
    }
}
public class w8q3 {
    private static final Logger logger = LogManager.getLogger(w8q3.class);

    public static void main(String[] args) {
        // Provide an incorrect URL for demonstration purposes
        String urlString = "https://example.com";

        // Using try-with-resources with ConnectionWrapper
        try (ConnectionWrapper connectionWrapper = openConnection(urlString)) {
            HttpURLConnection connection = connectionWrapper.connection();
            // Perform operations with the connection (not shown in this example)
            logger.info("Successfully connected to " + urlString);
        } catch (NetworkConnectionException e) {
            // Handle the custom exception
            logger.error("Custom exception caught: " + e.getMessage());
        } catch (IOException e) {
            // Handle other IO-related exceptions
            logger.error("IOException caught: " + e.getMessage());
        } finally {
            // Log a message indicating the successful closure of the HttpURLConnection
            logger.info("Finally block executed.");
        }
    }
    // Method to open a connection and throw custom exception if an issue occurs
    private static ConnectionWrapper openConnection(String urlString) throws NetworkConnectionException, IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Additional configuration or operations can be performed here
            return new ConnectionWrapper(connection);
        } catch (IOException e) {
            // Log the original exception and throw a custom exception
            logger.error("IOException caught while opening connection: " + e.getMessage());
            throw new NetworkConnectionException("Error establishing network connection.");
        }
    }
}
