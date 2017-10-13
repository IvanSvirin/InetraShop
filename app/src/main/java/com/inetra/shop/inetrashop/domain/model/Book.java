package com.inetra.shop.inetrashop.domain.model;

abstract class Book extends Product {
    private int pagesNumber;
    Book(String name, double price, String barcode, int pagesNumber) {
        super(name, price, barcode);
        this.pagesNumber = pagesNumber;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
}
