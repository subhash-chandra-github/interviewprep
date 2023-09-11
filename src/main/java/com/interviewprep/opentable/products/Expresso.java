package com.interviewprep.opentable.products;

import com.interviewprep.opentable.items.Coffe;

/**
 * Created by subhash on 28/11/2022.
 */
public class Expresso extends Product{


    public Expresso() {
        super(2);
        addIngredients(new Coffe(),10);

    }


}
