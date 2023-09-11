package com.interviewprep.threadPractice.preoducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by subhash on 21/10/20.
 */
public class Buffer {

    private Queue<Integer> list;
    private int size;

    public Buffer(int size)
    {
        this.size = size;
        this.list = new ArrayDeque<>();

    }

    public void produce() throws InterruptedException
    {

        int value = 0;
        while (true)
        {
            synchronized (this)
            {
                while (list.size()>=size)
                {
                    wait();
                }
                list.add(value);
                value++;
                System.out.println("Prdouced "+value+" "+Thread.currentThread().getName());
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        while(true)
        {
            synchronized (this)
            {
                while (list.size()==0)
                {
                    wait();
                }
                int v = list.poll();
                System.out.println("Consumed"+v+" "+Thread.currentThread().getName());
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
