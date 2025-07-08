package main.java.com.QuantumBookStore.services;

import main.java.com.QuantumBookStore.models.EBook;

public class MailService {
    public static void sendEBook(EBook book, int quantity, String email) {
        System.out.println("Quantum book store: Sending " + quantity + " copy(ies) of '" +
                book.getTitle() + "' (" + book.getFileType() + ") to " + email);
    }
}