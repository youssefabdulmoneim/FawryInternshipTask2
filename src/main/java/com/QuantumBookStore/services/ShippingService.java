package main.java.com.QuantumBookStore.services;

import main.java.com.QuantumBookStore.models.PaperBook;

public class ShippingService {
    public static void ship(PaperBook book, int quantity, String address) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '" +
                book.getTitle() + "' to " + address);
    }
}