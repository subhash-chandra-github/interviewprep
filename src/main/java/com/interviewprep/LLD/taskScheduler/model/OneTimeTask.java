package com.interviewprep.LLD.taskScheduler.model;

public class OneTimeTask extends ScheduledTask{

    private final long executionTime;

    public OneTimeTask(ExecutionContext context,String jobName, long executionTime) {
        super(context,jobName);
        this.executionTime = executionTime;
    }
    @Override
    public boolean isRecurring() {
        return false;
    }

    @Override
    public ScheduledTask nextScheduledTask() {
        return null;
    }

    @Override
    public long getNextExecutionTime() {
        return executionTime;
    }
}
