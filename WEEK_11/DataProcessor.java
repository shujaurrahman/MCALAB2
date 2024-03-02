package WEEK_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor<T> {
    private List<T> list;

    public DataProcessor() {
        list = new ArrayList<>();
    }

    public void addElement(T element) {
        list.add(element);
    }

    public void removeElement(T element) {
        list.remove(element);
    }

    public void displayElements() {
        System.out.println("Elements in DataProcessor:");
        for (T element : list) {
            System.out.println(element);
        }
    }

    public void arrayListOperations() {
        System.out.println("ArrayList Operations:");
        // Add an element
        T firstElement = list.get(0);
        list.add(firstElement);
        System.out.println("Added an element: " + firstElement);

        // Remove an element
        T removedElement = list.remove(1);
        System.out.println("Removed element: " + removedElement);

        // Search for an element
        System.out.println("Search for an element: " + list.contains(list.get(2)));
    }

    public void hashMapOperations(Map<Integer, T> hashMap) {
        System.out.println("HashMap Operations:");
        // Add elements to HashMap
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(i, list.get(i));
        }

        // Remove an element from HashMap
        if (!hashMap.isEmpty()) {
            Integer firstKey = hashMap.keySet().iterator().next();
            T removedElement = hashMap.remove(firstKey);
            System.out.println("Removed element from HashMap: " + removedElement);
        }

        // Retrieve elements from HashMap
        for (Integer key : hashMap.keySet()) {
            T value = hashMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public void combineCollections(List<? extends T> collection) {
        list.addAll(collection);
        System.out.println("Combined collection with existing DataProcessor:");
        displayElements();
    }

    public static void main(String[] args) {
        DataProcessor<Integer> intProcessor = new DataProcessor<>();
        DataProcessor<String> stringProcessor = new DataProcessor<>(); // Change to String

        // Add elements to DataProcessor instances
        intProcessor.addElement(10);
        intProcessor.addElement(20);
        intProcessor.addElement(30);

        stringProcessor.addElement("Apple");
        stringProcessor.addElement("Banana");
        stringProcessor.addElement("Orange");

        // Use ArrayList for storing and manipulating elements
        intProcessor.arrayListOperations();

        // Extend to work with HashMap
        Map<Integer, Integer> intHashMap = new HashMap<>(); // Change to Integer
        intProcessor.hashMapOperations(intHashMap);

        // Generics with Wildcards: Combine collections with existing DataProcessor
        List<Integer> integerList = new ArrayList<>(); // Change to Integer
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        intProcessor.combineCollections(integerList);
    }

}
