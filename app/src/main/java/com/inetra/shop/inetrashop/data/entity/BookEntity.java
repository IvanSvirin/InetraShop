package com.inetra.shop.inetrashop.data.entity;

public abstract class BookEntity extends ProductEntity {
    private int pagesNumber;
    public BookEntity(String name, double price, String barcode, int pagesNumber) {
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
