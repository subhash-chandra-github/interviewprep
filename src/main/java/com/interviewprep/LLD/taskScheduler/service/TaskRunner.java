package com.interviewprep.LLD.taskScheduler.service;

import com.interviewprep.LLD.taskScheduler.model.ScheduledTask;
import com.interviewprep.LLD.taskScheduler.repository.TaskStore;

public class TaskRunner implements Runnable {


    private final TaskStore<ScheduledTask> taskStore;
    public boolean running = true;

    public TaskRunner(TaskStore<ScheduledTask> taskStore) {
        this.taskStore = taskStore;
    }

    @Override
    public void run() {
        while (running){
            ScheduledTask scheduledTask = taskStore.poll();
            if(scheduledTask==null){
                break;
            }
            scheduledTask.execute();
            if (scheduledTask.isRecurring()) {
                taskStore.add(scheduledTask.nextScheduledTask());
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
