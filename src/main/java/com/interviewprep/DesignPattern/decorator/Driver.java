package com.interviewprep.DesignPattern.decorator;

public class Driver {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product p = new MobilePhone("Iphone",ProductType.ELECTRONICS,100.0);

        shoppingCart.addToCart(p);

        System.out.println(shoppingCart.getTotal());
    }
}
