package com.inetra.shop.inetrashop.domain.model;

public class BookOnCooking extends Book {
    private String majorIngredient;

    public BookOnCooking(String name, double price, String barcode, int pagesNumber, String majorIngredient) {
        super(name, price, barcode, pagesNumber);
        this.majorIngredient = majorIngredient;
    }

    public String getMajorIngredient() {
        return majorIngredient;
    }

    public void setMajorIngredient(String majorIngredient) {
        this.majorIngredient = majorIngredient;
    }
}
