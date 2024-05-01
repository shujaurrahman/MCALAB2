package WEEK_12;

import java.util.ArrayList;
import java.util.List;

// Book class representing individual books in the library
class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final String genre;
    private boolean available;

    public Book(int bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }

    // Getters and setters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// User class representing library users
class User {
    private final String name;
    private final List<Book> borrowedBooks;

    public User(int userId, String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Method to borrow a book
    public void borrowBook(Book book, Catalog catalog) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is not available.");
        }
    }

    // Method to return a book
    public void returnBook(Book book, Catalog catalog) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
        System.out.println(name + " returned the book: " + book.getTitle());
    }
}

// Catalog class representing the library catalog
class Catalog {
    private final List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book to catalog: " + book.getTitle());
    }

    // Method to display available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class OnlineLibrarySystem {
    public static void main(String[] args) {
        // Create a catalog
        Catalog catalog = new Catalog();

        // Add books to the catalog
        Book book1 = new Book(1, "Java Programming", "John Doe", "Programming");
        Book book2 = new Book(2, "Data Structures", "Jane Smith", "Computer Science");
        catalog.addBook(book1);
        catalog.addBook(book2);

        // Display initial catalog status
        System.out.println("Initial Catalog Status:");
        catalog.displayAvailableBooks();
        System.out.println();

        // Create users
        User user1 = new User(101, "Alice");
        User user2 = new User(102, "Bob");

        // Simulate borrowing and returning books
        user1.borrowBook(book1, catalog);
        user2.borrowBook(book2, catalog);
        user1.borrowBook(book2, catalog); // Try to borrow a book already borrowed by another user
        user1.returnBook(book1, catalog);

        // Display catalog status after transactions
        System.out.println("\nCatalog Status After Transactions:");
        catalog.displayAvailableBooks();
    }
}


