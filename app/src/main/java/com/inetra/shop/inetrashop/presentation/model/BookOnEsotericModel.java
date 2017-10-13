package com.inetra.shop.inetrashop.presentation.model;

public class BookOnEsotericModel extends BookModel {
    private int readerAge;

    public BookOnEsotericModel(String name, double price, String barcode, int pagesNumber, int readerAge) {
        super(name, price, barcode, pagesNumber);
        this.readerAge = readerAge;
    }

    public int getReaderAge() {
        return readerAge;
    }

    public void setReaderAge(int readerAge) {
        this.readerAge = readerAge;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Reader age: " + readerAge + "\n";
    }
}
