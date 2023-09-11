package com.interviewprep.opentable.products;

import com.interviewprep.opentable.items.Milk;

/**
 * Created by subhash on 28/11/2022.
 */
public class Cappuccino extends Product{

    public Cappuccino() {
        super(4);
        new Expresso().getIngredeinets().forEach((key,value)->{
            addIngredients(key,value);
        });
        addIngredients(new Milk(),10);

    }
}
