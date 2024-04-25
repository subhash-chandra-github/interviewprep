package com.interviewprep.LLD.splitwise.split;

import com.interviewprep.LLD.splitwise.user.User;

public class ExactSplit extends Split{

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
