package com.interviewprep.LLD.taskScheduler.model;

public abstract class ScheduledTask {

    public final ExecutionContext context;
    public final String jobName;
    public ScheduledTask (ExecutionContext context, String jobName) {

        this.context = context;
        this.jobName = jobName;
    }

    public abstract boolean isRecurring();

    public void execute() {
        context.execute(this.jobName);
    }

    public abstract ScheduledTask nextScheduledTask();

    public abstract long getNextExecutionTime();
}
