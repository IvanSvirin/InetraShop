package com.inetra.shop.inetrashop.presentation.model;

public abstract class ProductModel {
    private String name;
    private double price;
    private String barcode;

    public ProductModel(String name, double price, String barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Name: " + name+ "\n" +
                "Price: " +  price + "\n" +
                "Barcode: " +  barcode + "\n";
    }
}
