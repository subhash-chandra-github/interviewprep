package com.interviewprep.LLD.taskScheduler.repository;

import com.interviewprep.LLD.taskScheduler.model.ScheduledTask;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTaskStore implements TaskStore<ScheduledTask>{

    private final PriorityBlockingQueue<ScheduledTask> taskQueue;
    private final Set<ScheduledTask> tasks;

    public PriorityBlockingQueueTaskStore(Integer queueSize, Comparator<ScheduledTask> comparator) {
        this.taskQueue = new PriorityBlockingQueue<>(queueSize,comparator);
        this.tasks = new HashSet<>();
    }
    @Override
    public void add(ScheduledTask task) {

        taskQueue.add(task);

    }

    @Override
    public ScheduledTask peek() {
        return taskQueue.peek();
    }

    @Override
    public ScheduledTask poll() {
        return taskQueue.poll();
    }

    @Override
    public boolean remove(ScheduledTask task) {
        if (tasks.contains(task)) {
            taskQueue.remove(task);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
}
