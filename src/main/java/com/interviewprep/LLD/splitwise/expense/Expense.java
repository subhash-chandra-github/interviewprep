package com.interviewprep.LLD.splitwise.expense;

import com.interviewprep.LLD.splitwise.user.User;
import com.interviewprep.LLD.splitwise.split.Split;

import java.util.List;

public abstract class Expense {

    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetadata metadata;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.metadata = metadata;
    }

    public abstract boolean validate();

    public List<Split> getSplits() {
        return splits;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
