package com.interviewprep.DesignPattern.Strategy;

public class CardPaymentStrategy implements PaymentStrategy {


    private  String cardNo;
    private String cvv;

    public CardPaymentStrategy(String cardNo, String cvv) {
        this.cardNo = cardNo;
        this.cvv = cvv;
    }


    @Override
    public void pay() {
        System.out.println("Payment made through card No: "+this.cardNo+" having cvv no:"+this.cvv);

    }
}
