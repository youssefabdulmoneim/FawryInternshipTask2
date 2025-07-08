package main.java.com.QuantumBookStore.models;

// Showcase/Demo book which is not for sale
public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, author, year, price);
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new RuntimeException("Showcase books are not for sale");
    }

    @Override
    public boolean isAvailableForPurchase() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " [Showcase Book - Not for Sale]";
    }
}