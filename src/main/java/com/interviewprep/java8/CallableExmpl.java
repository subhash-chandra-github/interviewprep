package com.interviewprep.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by subhash on 20/10/20.
 */
public class CallableExmpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new CallableExmpl();
        for(int i=0; i< 10; i++){
            Future<String> future = executor.submit(callable);
            futureList.add(future);
        }
        for(Future<String> fut : futureList){
            try {
                System.out.println(new Date()+ "::"+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
