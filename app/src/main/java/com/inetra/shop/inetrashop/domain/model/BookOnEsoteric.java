package com.inetra.shop.inetrashop.domain.model;

public class BookOnEsoteric extends Book {
    private int readerAge;

    public BookOnEsoteric(String name, double price, String barcode, int pagesNumber, int readerAge) {
        super(name, price, barcode, pagesNumber);
        this.readerAge = readerAge;
    }

    public int getReaderAge() {
        return readerAge;
    }

    public void setReaderAge(int readerAge) {
        this.readerAge = readerAge;
    }
}
