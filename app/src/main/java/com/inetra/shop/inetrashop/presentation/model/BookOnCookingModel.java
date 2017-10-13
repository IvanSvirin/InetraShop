package com.inetra.shop.inetrashop.presentation.model;

public class BookOnCookingModel extends BookModel {
    private String majorIngredient;

    public BookOnCookingModel(String name, double price, String barcode, int pagesNumber, String majorIngredient) {
        super(name, price, barcode, pagesNumber);
        this.majorIngredient = majorIngredient;
    }

    public String getMajorIngredient() {
        return majorIngredient;
    }

    public void setMajorIngredient(String majorIngredient) {
        this.majorIngredient = majorIngredient;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Major ingredient: " + majorIngredient + "\n";
    }
}
