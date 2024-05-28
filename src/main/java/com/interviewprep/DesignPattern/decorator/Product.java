package com.interviewprep.DesignPattern.decorator;

public abstract class Product {


     String name;
     ProductType type;

     double originalPrice;

    public Product() {
    }

    public Product(String name, ProductType type, double originalPrice) {
        this.name = name;
        this.type = type;
        this.originalPrice = originalPrice;
    }

    public abstract double getPrice();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

}
