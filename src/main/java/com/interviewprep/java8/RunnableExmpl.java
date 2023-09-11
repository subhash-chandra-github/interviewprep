package com.interviewprep.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExmpl implements Runnable{


 private volatile int i = 1;

    @Override
    public void run() {
        for(int k=0;k<5;k++) {
            System.out.println(i++);
        }
    }

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(5);
        RunnableExmpl exmpl = new RunnableExmpl();
        for(int i=0;i<5;i++){
//            service.submit(exmpl);
            CompletableFuture.runAsync(() ->
                    exmpl.run(), service);
//
        }
//        CompletableFuture.runAsync(() ->
//                exmpl.run(), service);
        System.out.println("IN MAIN");
        service.shutdown();
    }
}
