package com.inetra.shop.inetrashop.data.entity;

public class BookOnProgrammingEntity extends BookEntity {
    private String programmingLanguage;

    public BookOnProgrammingEntity(String name, double price, String barcode, int pagesNumber, String programmingLanguage) {
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
