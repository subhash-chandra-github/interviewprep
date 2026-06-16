package com.interviewprep.lld.cofeeVendingMachine.products;

import com.interviewprep.lld.cofeeVendingMachine.items.Coffe;

/**
 * Created by subhash on 28/11/2022.
 */
public class Expresso extends Product {


    public Expresso() {
        super(2);
        addIngredients(new Coffe(),10);

    }


}
