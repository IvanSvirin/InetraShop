package com.inetra.shop.inetrashop.domain.model;

public class BookOnProgramming extends Book {
    private String programmingLanguage;

    public BookOnProgramming(String name, double price, String barcode, int pagesNumber, String programmingLanguage) {
        super(name, price, barcode, pagesNumber);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
