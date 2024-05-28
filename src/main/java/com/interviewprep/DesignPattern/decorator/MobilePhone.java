package com.interviewprep.DesignPattern.decorator;

public class MobilePhone extends Product{


    public MobilePhone(String name, ProductType type, double originalPrice) {
        super(name, type, originalPrice);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
