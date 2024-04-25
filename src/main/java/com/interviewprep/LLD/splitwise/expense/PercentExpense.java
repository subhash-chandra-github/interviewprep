package com.interviewprep.LLD.splitwise.expense;

import com.interviewprep.LLD.splitwise.user.User;
import com.interviewprep.LLD.splitwise.split.PercentSplit;
import com.interviewprep.LLD.splitwise.split.Split;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit exactSplit = (PercentSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}
