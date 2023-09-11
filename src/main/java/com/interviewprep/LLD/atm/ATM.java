package com.interviewprep.LLD.atm;

public abstract class ATM {
        int atmID;
        Address location;
        CashDispenser cashDispenser;
        Screen screen;
        CardReader cardReader;
        KeyPad keypad;
        Printer printer;
//        boolean authenticate(Card card);
//        boolean executeTransaction(Customer customer,
//                                   Transaction transaction);
}
