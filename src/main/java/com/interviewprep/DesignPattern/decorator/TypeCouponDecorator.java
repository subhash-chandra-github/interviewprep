package com.interviewprep.DesignPattern.decorator;

import java.util.Arrays;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{

    Product product;
    int discount;

    List<ProductType> eligible;

    public TypeCouponDecorator(Product product, int discount) {
        this.product = product;
        this.discount = discount;
        this.eligible = Arrays.asList(ProductType.ELECTRONICS);
    }

    @Override
    public double getPrice() {

        double price = product.getPrice();
        if(eligible.contains(product.type)){
            return price - (price*discount)/100;
        }
        return price;
    }
}
