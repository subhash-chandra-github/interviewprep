package com.interviewprep.threadPractice.preoducerConsumer;

/**
 * Created by subhash on 21/10/20.
 */
public class ProducerConsumer {



    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        Thread producerThread = new Thread(()->
        {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(()->
        {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
