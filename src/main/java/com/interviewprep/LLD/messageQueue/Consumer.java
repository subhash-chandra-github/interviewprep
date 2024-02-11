package com.interviewprep.LLD.messageQueue;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {


    private String id;

    private TopicsRepository topicsRepository;
    private AtomicInteger offset;

    public Consumer(String id, TopicsRepository topicsRepository) {
        this.id = id;
        this.topicsRepository = topicsRepository;
        this.offset = new AtomicInteger(0);
    }

    public void consume(String mesage){
        System.out.println(this.id+" received message "+mesage);

    }

    public void subScribe(String topicName){

        Topic topic = topicsRepository.getTopic(topicName);
        topic.addConsumer(this);

    }

    public void unSubScribe(String topicName){

        Topic topic = topicsRepository.getTopic(topicName);
        topic.removeConsumer(this);

    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }
}
