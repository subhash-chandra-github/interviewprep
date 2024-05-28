package com.interviewprep.DesignPattern.decorator;

public class PercentageCouponDecorator extends CouponDecorator{


    Product product;
    int discount;

    public PercentageCouponDecorator(Product product, int discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public double getPrice() {

        double price = product.getPrice();
        return price - (price*discount)/100;
    }
}
