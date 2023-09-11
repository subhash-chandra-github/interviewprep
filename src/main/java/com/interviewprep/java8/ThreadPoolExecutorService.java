package com.interviewprep.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by subhash on 20/10/20.
 */
public class ThreadPoolExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++)
        {
            Runnable thread = new WorkerThread(""+i);
            executorService.execute(thread);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
    }

    class WorkerThread implements  Runnable{
        private String command;

        public WorkerThread(String s){
            this.command=s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
            System.out.println(Thread.currentThread().getName()+" End.");
        }
    }
