package Swing_Playground;
import java.util.Scanner;
class Node<T, U> {
    T data1;
    U data2;
    Node<T, U> next;

    Node(T data1, U data2) {
        this.data1 = data1;
        this.data2 = data2;
        this.next = null;
    }
}

class LinkedList<T, U> {
    Node<T, U> head;

    public void insert(T data1, U data2) {
        Node<T, U> newNode = new Node<>(data1, data2);
        if (head == null) {
            head = newNode;
        } else {
            Node<T, U> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node<T, U> temp = head;
        while (temp != null) {
            System.out.println("(" + temp.data1 + ", " + temp.data2 + ")");
            temp = temp.next;
        }
    }
}

public class LinkeListAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create linked list for strings
        LinkedList<String, Integer> stringList = new LinkedList<>();
        System.out.print("Enter the number of elements for the string list: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements for the string list:");
        for (int i = 0; i < n; i++) {
            String data = scanner.next();
            stringList.insert(data, null); // Inserting null for integers for now
        }

        // Create linked list for integers
        LinkedList<Integer, String> integerList = new LinkedList<>();
        System.out.print("Enter the number of elements for the integer list: ");
        n = scanner.nextInt();
        System.out.println("Enter elements for the integer list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            integerList.insert(data, null); // Inserting null for strings for now
        }

        // Create combined linked list
        LinkedList<String, Integer> combinedList = new LinkedList<>();
        Node<String, Integer> stringNode = stringList.head;
        Node<Integer, String> integerNode = integerList.head;
        while (stringNode != null && integerNode != null) {
            combinedList.insert(stringNode.data1, integerNode.data1);
            stringNode = stringNode.next;
            integerNode = integerNode.next;
        }

        // Display combined linked list
        System.out.println("Combined linked list:");
        combinedList.display();
    }
}
