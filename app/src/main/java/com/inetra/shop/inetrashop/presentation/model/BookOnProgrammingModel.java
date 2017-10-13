package com.inetra.shop.inetrashop.presentation.model;


public class BookOnProgrammingModel extends BookModel {
    private String programmingLanguage;

    public BookOnProgrammingModel(String name, double price, String barcode, int pagesNumber, String programmingLanguage) {
        super(name, price, barcode, pagesNumber);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Programming language: " + programmingLanguage + "\n";
    }
}
