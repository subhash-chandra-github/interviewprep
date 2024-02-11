package com.interviewprep.LLD.messageQueue;

import java.util.ArrayList;
import java.util.List;

public class Topic {


    private String name;
    private List<String> message;
    private List<Consumer> consumers;

    public Topic(String name) {
        this.name = name;
        this.consumers = new ArrayList<>();
        this.message = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addConsumer(Consumer consumer){
        this.consumers.add(consumer);
    }

    public void removeConsumer(Consumer consumer){
        this.consumers.remove(consumer);
    }


    public void publishToTopic(String message){
        synchronized (this) {
            this.message.add(message);
        }
    }

    public List<Consumer> getConsumers(){
        return this.consumers;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
