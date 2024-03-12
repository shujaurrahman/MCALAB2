package WEEK_8;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class w8q1{
    private static final Logger log = Logger.getLogger(w8q1.class);
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/w8q1";
    private static final String USER = "root";
    private static final String PASSWORD = "Opssasur@19";

    public static void main(String[] args) {
        try {
            // Use try-with-resources to manage the Connection object
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                log.info("Database connection established successfully.");
            } catch (SQLException e) {
                // Catch and rethrow a custom exception for database connection issues
                throw new DatabaseConnectionException("Error connecting to the database", e);
            } finally {
                // Log a message indicating the successful closure of the database connection
                log.info("Closing the database connection.");
            }
        } catch (DatabaseConnectionException e) {
            // Catch and handle the custom exception
            log.error("Custom Exception: " + e.getMessage(), e);
        }
    }
}
