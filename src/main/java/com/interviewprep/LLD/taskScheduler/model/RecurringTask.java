package com.interviewprep.LLD.taskScheduler.model;

public class RecurringTask extends ScheduledTask{

    private final long executionTime;
    private final long interval;

    public RecurringTask(ExecutionContext context, String jobName, long executionTime, long interval) {
        super(context,jobName);
        this.executionTime = executionTime;
        this.interval = interval;
    }
    @Override
    public boolean isRecurring() {
        return true;
    }

    @Override
    public ScheduledTask nextScheduledTask() {
        return new RecurringTask(context, jobName,executionTime + interval, interval);
    }

    @Override
    public long getNextExecutionTime() {
        return executionTime;
    }
}
