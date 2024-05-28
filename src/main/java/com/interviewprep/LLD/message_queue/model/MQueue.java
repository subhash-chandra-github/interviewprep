package com.interviewprep.LLD.message_queue.model;

import com.interviewprep.LLD.message_queue.handler.TopicHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MQueue {

    private final Map<String, TopicHandler> topicProcessors;

    public MQueue() {
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(String topicName){

        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getId(),topicHandler);
        System.out.println("Created topic: " + topic.getName());
        return topic;
    }
    public void subscribe(Consumer subscriber, Topic topic) {
        topic.addSubscriber(subscriber);
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getName());
    }

    public void publish(Topic topic,Message message) {
        topic.addMessage(message);
        System.out.println(message.getContent() + " published to topic: " + topic.getName());
        new Thread(() -> topicProcessors.get(topic.getId()).publish()).start();
    }
}
