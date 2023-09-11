package com.interviewprep.opentable.products;

import com.interviewprep.opentable.items.Milk;
import com.interviewprep.opentable.products.Cappuccino;
import com.interviewprep.opentable.products.Product;

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
