package com.inetra.shop.inetrashop.data.entity;

public class BookOnCookingEntity extends BookEntity {
    private String majorIngredient;

    public BookOnCookingEntity(String name, double price, String barcode, int pagesNumber, String majorIngredient) {
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
