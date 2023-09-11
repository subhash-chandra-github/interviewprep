package com.interviewprep.LLD.VendingMachine;

/**
 * Created by subhash on 28/11/2022.
 */
public enum Coin {

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

    private int denomination;

    private Coin(int denomination){
        this.denomination = denomination;
    }

    public int getDenomination(){
        return denomination;
    }
}
