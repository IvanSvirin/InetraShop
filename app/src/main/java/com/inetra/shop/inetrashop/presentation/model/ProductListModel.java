package com.inetra.shop.inetrashop.presentation.model;

public class ProductListModel extends ProductModel {
    private String category;
    private String subCategory;

    public ProductListModel(String name, double price, String barcode, String category, String subCategory) {
        super(name, price, barcode);
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
