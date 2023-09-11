package com.interviewprep.DesignPattern.Strategy;

public class NetBankingPaymentStrategy implements PaymentStrategy{

    private String bankName;

    public NetBankingPaymentStrategy(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay() {
        System.out.println("Payment made through Net banking Bank name : "+bankName);
    }
}
