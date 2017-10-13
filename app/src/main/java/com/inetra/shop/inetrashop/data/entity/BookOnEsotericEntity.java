package com.inetra.shop.inetrashop.data.entity;

public class BookOnEsotericEntity extends BookEntity {
    private int readerAge;

    public BookOnEsotericEntity(String name, double price, String barcode, int pagesNumber, int readerAge) {
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
