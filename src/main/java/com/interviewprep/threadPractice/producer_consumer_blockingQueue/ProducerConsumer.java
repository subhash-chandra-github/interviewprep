package com.interviewprep.threadPractice.producer_consumer_blockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread producer = new Thread(() -> {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread - Producer");

        Thread consumer = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread - Consumer");
        producer.start();
        consumer.start();

    }
}
