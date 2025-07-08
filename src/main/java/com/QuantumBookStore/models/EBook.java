package main.java.com.QuantumBookStore.models;

import main.java.com.QuantumBookStore.services.MailService;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        MailService.sendEBook(this, quantity, email);
    }

    @Override
    public boolean isAvailableForPurchase() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " [EBook - " + fileType + "]";
    }
}