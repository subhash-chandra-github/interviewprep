package com.interviewprep.LLD.splitwise.expense;

import com.interviewprep.LLD.splitwise.user.User;
import com.interviewprep.LLD.splitwise.split.EqualSplit;
import com.interviewprep.LLD.splitwise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
