package WEEK_11;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedProcessor<T> {
    private List<T> elements;

    public ThreadedProcessor() {
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void process(Processor<T> processor) {
        ExecutorService executorService = Executors.newFixedThreadPool(elements.size());
        for (T element : elements) {
            executorService.execute(() -> processor.process(element));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        ThreadedProcessor<Integer> integerProcessor = new ThreadedProcessor<>();
        ThreadedProcessor<String> stringProcessor = new ThreadedProcessor<>();

        integerProcessor.addElement(1);
        integerProcessor.addElement(2);
        integerProcessor.addElement(3);

        stringProcessor.addElement("Hello");
        stringProcessor.addElement("World");

        Processor<Integer> integerSumProcessor = element -> {
            int sum = element + 10;
            System.out.println("Processed Integer: " + element + ", Result: " + sum);
        };

        Processor<String> stringProcessorTask = element -> {
            String result = element.toUpperCase();
            System.out.println("Processed String: " + element + ", Result: " + result);
        };

        System.out.println("Processing Integers:");
        integerProcessor.process(integerSumProcessor);

        System.out.println("\nProcessing Strings:");
        stringProcessor.process(stringProcessorTask);
    }
}

interface Processor<T> {
    void process(T element);
}
