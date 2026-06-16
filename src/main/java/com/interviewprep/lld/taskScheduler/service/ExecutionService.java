package com.interviewprep.lld.taskScheduler.service;

import com.interviewprep.lld.taskScheduler.model.ExecutionContext;

public class ExecutionService implements ExecutionContext {


    @Override
    public void execute(String jobName) {

        System.out.println("Job "+jobName+" run has completed");

    }
}
