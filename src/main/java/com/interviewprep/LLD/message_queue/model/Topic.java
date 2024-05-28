package com.interviewprep.LLD.message_queue.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Topic {


    private String id;
    private String name;
    private List<Message> messages;
    private  List<Consumer> consumers;
    public Topic(@NonNull final String topicName, @NonNull final String topicId) {
        this.name = topicName;
        this.id = topicId;
        this.messages = new ArrayList<>();
        this.consumers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull final Message message) {
        messages.add(message);
    }

    public void addSubscriber(@NonNull final Consumer consumer) {
        consumers.add(consumer);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }
}
