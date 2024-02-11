package com.interviewprep.LLD.messageQueue;

public class Driver {


    public static void main(String[] args) {

        TopicsRepository topicsRepository = new TopicsRepository();

        TestTopic topic1 = new TestTopic("Test");
        TestTopic topic2 = new TestTopic("Test-2");

        topicsRepository.addTopic(topic1);
        topicsRepository.addTopic(topic2);

        Publisher publisher = new Publisher(topicsRepository,1);
        Consumer consumer = new Consumer("cosumer-1", topicsRepository);
        consumer.subScribe("Test");
        publisher.publish("Test","test message");



        Publisher publisher2 = new Publisher(topicsRepository,2);
        Consumer consumer2 = new Consumer("cosumer-2", topicsRepository);
        consumer2.subScribe("Test-2");
        consumer.subScribe("Test-2");

        publisher2.publish("Test-2","test message topic name : Test-2");
    }
}
