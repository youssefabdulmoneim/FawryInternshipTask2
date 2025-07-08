package main.java.com.QuantumBookStore.models;

import main.java.com.QuantumBookStore.services.ShippingService;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new RuntimeException("Not enough stock available. Current stock: " + stock);
        }
        stock -= quantity;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        reduceStock(quantity);
        ShippingService.ship(this, quantity, address);
    }

    @Override
    public boolean isAvailableForPurchase() {
        return stock > 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Paper Book - Stock: " + stock + "]";
    }
}