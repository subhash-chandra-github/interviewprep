package com.interviewprep.LLD.messageQueue;

public class Publisher {


    private TopicsRepository topicsRepository;
    private int id;

    public Publisher(TopicsRepository topicsRepository, int id) {
        this.topicsRepository = topicsRepository;
        this.id = id;
    }

    public void publish(String topicName, String message){
        Topic topic = topicsRepository.getTopic(topicName);
        topic.publishToTopic(message);

    }
}
