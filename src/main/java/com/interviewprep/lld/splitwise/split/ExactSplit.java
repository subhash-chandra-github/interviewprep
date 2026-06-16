package com.interviewprep.lld.splitwise.split;

import com.interviewprep.lld.splitwise.user.User;

public class ExactSplit extends Split{

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
