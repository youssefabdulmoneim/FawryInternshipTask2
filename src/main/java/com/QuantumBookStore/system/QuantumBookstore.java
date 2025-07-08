package main.java.com.QuantumBookStore.system;

import java.util.*;
import main.java.com.QuantumBookStore.models.*;


public class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }

    public List<Book> removeOutdatedBooks(int years) {
        List<Book> removedBooks = new ArrayList<>();
        int currentYear = 2025;

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > years) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new RuntimeException("Book with ISBN " + isbn + " not found in inventory");
        }

        if (!book.isAvailableForPurchase()) {
            throw new RuntimeException("Book is not available for purchase");
        }

        book.processPurchase(quantity, email, address);

        double totalAmount = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase completed. Total amount: $" + totalAmount);

        return totalAmount;
    }

    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        for (Book book : inventory.values()) {
            System.out.println("Quantum book store: " + book);
        }
    }
}