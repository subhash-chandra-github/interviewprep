package com.interviewprep.lld.taskScheduler.repository;

import com.interviewprep.lld.taskScheduler.model.ScheduledTask;

public interface TaskStore <T extends ScheduledTask> {

    void add(T task);

    T peek();

    T poll();

    boolean remove(T task);

    boolean isEmpty();

}
