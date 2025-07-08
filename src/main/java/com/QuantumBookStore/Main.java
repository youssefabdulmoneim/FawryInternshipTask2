package main.java.com.QuantumBookStore;

import main.java.com.QuantumBookStore.models.Book;
import main.java.com.QuantumBookStore.models.EBook;
import main.java.com.QuantumBookStore.models.PaperBook;
import main.java.com.QuantumBookStore.models.ShowcaseBook;
import main.java.com.QuantumBookStore.system.QuantumBookstore;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println();
        store.addBook(new PaperBook("978-1234567890", "Java Programming", "John", 2020, 29.99, 10));
        store.addBook(new EBook("978-0987654321", "Data Structures", "Jane", 2019, 19.99, "PDF"));
        store.addBook(new ShowcaseBook("978-1111111111", "Advanced Algorithms", "Bob", 2021, 39.99));
        store.addBook(new PaperBook("978-2222222222", "Old Programming Book", "Alice", 2010, 15.99, 5));

        System.out.println("\n----------- Quantum book store: Current Inventory -----------");
        store.displayInventory();
        System.out.println();
        System.out.println();

        try {
            // Paper Book
            double amount1 = store.buyBook("978-1234567890", 2, "customer1@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount1);
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        try {
            // An ebook
            double amount2 = store.buyBook("978-0987654321", 1, "customer2@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount2);
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        try {
            // A showcase book
            double amount3 = store.buyBook("978-1111111111", 1, "customer3@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        try {
            // More than available stock
            double amount4 = store.buyBook("978-1234567890", 20, "customer4@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        List<Book> removedBooks = store.removeOutdatedBooks(10);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");

        System.out.println("\n----------- Quantum book store: Final Inventory -----------");
        store.displayInventory();
    }
}