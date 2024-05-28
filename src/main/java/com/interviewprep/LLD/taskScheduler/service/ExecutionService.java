package com.interviewprep.LLD.taskScheduler.service;

import com.interviewprep.LLD.taskScheduler.model.ExecutionContext;

public class ExecutionService implements ExecutionContext {


    @Override
    public void execute(String jobName) {

        System.out.println("Job "+jobName+" run has completed");

    }
}
