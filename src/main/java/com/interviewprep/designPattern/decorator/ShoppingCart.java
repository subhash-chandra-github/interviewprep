package com.interviewprep.designPattern.decorator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> products;


    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addToCart(Product product){

        Product productWithDiscount = new TypeCouponDecorator(
                new PercentageCouponDecorator(product,5),5);
        products.add(productWithDiscount);

    }
    public int getTotal(){
        int totalPrice = 0;
        for(Product p : products){
            totalPrice = totalPrice+(int)p.getPrice();
        }
        return totalPrice;
    }

}
