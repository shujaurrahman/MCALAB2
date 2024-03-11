package WEEK_9;
import java.util.ArrayList;
import java.util.List;

public class w9q2 {
    private static final long MAX_MEMORY_THRESHOLD = 90 * 1024 * 1024; // Max memory threshold in bytes (e.g., 90 MB) change to 1000 for gracefully handling outofmemory exception
    private static final long MONITOR_INTERVAL = 1000; // Monitoring interval in milliseconds

    public static void main(String[] args) {
        try {
            startMonitoring();
        } catch (InterruptedException e) {
            System.err.println("Monitoring thread interrupted!");
        }
    }

    private static void startMonitoring() throws InterruptedException {
        Thread monitoringThread = new Thread(() -> {
            try {
                while (true) {
                    long freeMemory = Runtime.getRuntime().freeMemory();
                    if (freeMemory < MAX_MEMORY_THRESHOLD) {
                        handleOutOfMemory();
                        break;
                    }
                    allocateMemory(); // Allocate memory to potentially trigger OutOfMemoryError
                    Thread.sleep(MONITOR_INTERVAL);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        monitoringThread.start();
        monitoringThread.join();
    }

    private static void allocateMemory() {
        List<byte[]> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new byte[10 * 1024 * 1024]); // Allocate 10 MB of memory
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Memory allocation exceeded available heap space.");
        }
    }

    private static void handleOutOfMemory() {
        System.out.println("System is about to run out of memory. Gracefully terminating the program.");
        // Clean up resources or take appropriate actions to gracefully handle the situation
        System.exit(1);
    }
}
