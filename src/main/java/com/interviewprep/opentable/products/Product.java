package com.interviewprep.opentable.products;

import com.interviewprep.opentable.items.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhash on 28/11/2022.
 */
public class Product {

    private Map<Item,Integer> requiedIngredients;
    private double totalPrice;
    public Product(int basePrice) {
        requiedIngredients = new HashMap<>();
        totalPrice = basePrice;
    }
    public void addIngredients(Item item, int quantity){

        requiedIngredients.put(item,quantity);
    }

    public Map<Item,Integer> getIngredeinets(){
        return requiedIngredients;
    }

    public double getBasePrice(){
        return totalPrice;
    }





}
