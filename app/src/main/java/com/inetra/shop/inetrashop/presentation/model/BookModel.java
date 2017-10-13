package com.inetra.shop.inetrashop.presentation.model;

abstract class BookModel extends ProductModel {
    private int pagesNumber;
    BookModel(String name, double price, String barcode, int pagesNumber) {
        super(name, price, barcode);
        this.pagesNumber = pagesNumber;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Pages number: " + pagesNumber + "\n";
    }
}
