package com.interviewprep.LLD.taskScheduler.service;

import com.interviewprep.LLD.taskScheduler.model.ScheduledTask;
import com.interviewprep.LLD.taskScheduler.repository.TaskStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskScheduler {

    private final List<Runnable> threads;
    private final TaskStore<ScheduledTask> taskStore;

    public TaskScheduler(ExecutorConfig executorConfig, TaskStore<ScheduledTask> taskStore) {
        this.threads = new ArrayList<>();
        this.taskStore = taskStore;

        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < executorConfig.getNumThreads(); i++) {
            Thread thread = new Thread(new TaskRunner(this.taskStore));
            executor.submit(thread);
            threads.add(thread);
        }
    }

    public void stop() {
        threads.forEach(t -> ((TaskRunner) t).stop());
    }
}
