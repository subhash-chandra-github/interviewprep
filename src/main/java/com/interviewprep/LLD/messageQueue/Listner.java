package com.interviewprep.LLD.messageQueue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Listner implements Runnable {

    private TopicsRepository topicsRepository;

    public Listner(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }


    @Override
    public void run() {

        List<Topic> allTopics = topicsRepository.getAllTopics();

        for(Topic topic : allTopics){
            List<Consumer> consumers = topic.getConsumers();

            for(Consumer consumer : consumers){
                int offset  = consumer.getOffset().get();
                while(offset!=topic.getMessage().size()-1){
                    consumer.consume(topic.getMessage().get(offset));
                    offset = offset+1;
                }
                consumer.setOffset(new AtomicInteger(offset));

            }
        }
    }
}
