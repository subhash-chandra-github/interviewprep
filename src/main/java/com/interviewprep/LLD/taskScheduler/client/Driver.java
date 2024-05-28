package com.interviewprep.LLD.taskScheduler.client;

import com.interviewprep.LLD.taskScheduler.model.ExecutionContext;
import com.interviewprep.LLD.taskScheduler.model.OneTimeTask;
import com.interviewprep.LLD.taskScheduler.model.RecurringTask;
import com.interviewprep.LLD.taskScheduler.model.ScheduledTask;
import com.interviewprep.LLD.taskScheduler.repository.PriorityBlockingQueueTaskStore;
import com.interviewprep.LLD.taskScheduler.repository.TaskStore;
import com.interviewprep.LLD.taskScheduler.service.ExecutionService;
import com.interviewprep.LLD.taskScheduler.service.ExecutorConfig;
import com.interviewprep.LLD.taskScheduler.service.TaskScheduler;

import java.util.Comparator;

public class Driver {

    public static void main(String[] args) {

        ExecutionContext context = new ExecutionService();
        ScheduledTask oneTimeTask = new OneTimeTask(context,"One Time Job", 1715149050);
        ScheduledTask recurringJob = new RecurringTask(context,"Recurring Job 1", 1715149050,3600000);

        TaskStore<ScheduledTask> taskTaskStore = new PriorityBlockingQueueTaskStore(10, new Comparator<ScheduledTask>() {
            @Override
            public int compare(ScheduledTask o1, ScheduledTask o2) {
                return 0;
            }
        });
        taskTaskStore.add(oneTimeTask);
        taskTaskStore.add(recurringJob);

        ExecutorConfig executorConfig = new ExecutorConfig(2);

        TaskScheduler taskScheduler = new TaskScheduler(executorConfig,taskTaskStore);
    }
}
