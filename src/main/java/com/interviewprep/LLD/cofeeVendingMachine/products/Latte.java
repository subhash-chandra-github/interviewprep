package com.interviewprep.LLD.cofeeVendingMachine.products;

import com.interviewprep.LLD.cofeeVendingMachine.items.Milk;

/**
 * Created by subhash on 28/11/2022.
 */
public class Latte extends Product {

    public Latte() {
        super(4);
        new Cappuccino().getIngredeinets().forEach((key, value)->{
            addIngredients(key,value);
        });
        addIngredients(new Milk(),10);

    }

}
