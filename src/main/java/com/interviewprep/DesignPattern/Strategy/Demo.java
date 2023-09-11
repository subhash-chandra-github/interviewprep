package com.interviewprep.DesignPattern.Strategy;

public class Demo {

    public static void main(String[] args) {

        PaymentStrategy cardPaymentStrategy = new CardPaymentStrategy("4567892198763456","000");
        PaymentStrategy netBankingPaymentStrategy = new NetBankingPaymentStrategy("IDFC");

        cardPaymentStrategy.pay();
        netBankingPaymentStrategy.pay();
    }
}
