package com.interviewprep.LLD.VendingMachine;

import java.util.List;

/**
 * Created by subhash on 28/11/2022.
 */
public interface VendingMachine {

    long selectItemAndGetPrice(Item item);
    void insertCoin(Coin coin);
    List<Coin> refund();
    Bucket<Item, List<Coin>> collectItemAndChange();
    void reset();
}
