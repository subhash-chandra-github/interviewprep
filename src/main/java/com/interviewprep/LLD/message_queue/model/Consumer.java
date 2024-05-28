package com.interviewprep.LLD.message_queue.model;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {

    private AtomicInteger offset;
    private String id;
    private long sleepTimer;

    public Consumer(String id, long sleepTimer) {
        this.id = id;
        this.sleepTimer = sleepTimer;
        this.offset = new AtomicInteger(0);
    }
    public AtomicInteger getOffset() {
        return offset;
    }

    public String getId() {
        return id;
    }

    @SneakyThrows
    public void consume(Message message) {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getContent());
        Thread.sleep(sleepTimer);
        System.out.println("Subscriber: " + id + " done consuming: " + message.getContent());
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }

}
