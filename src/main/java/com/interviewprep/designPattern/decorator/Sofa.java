package com.interviewprep.designPattern.decorator;

public class Sofa extends Product{
    public Sofa(String name, ProductType type, double originalPrice) {
        super(name, type, originalPrice);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
