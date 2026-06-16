package com.interviewprep.threadPractice.producer_consumer_blockingQueue;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {

    private final BlockingQueue<Integer> q;

    public Buffer(int size) {
        this.q = new LinkedBlockingQueue<>(size);
    }

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            q.put(value);
            System.out.println("Produced: " +value+ " by "+Thread.currentThread().getName());
            value++;
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException{
        while(true){
           int value = q.take();
            System.out.println("Consumed: " +value+ " by "+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
