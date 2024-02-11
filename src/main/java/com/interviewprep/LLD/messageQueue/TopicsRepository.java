package com.interviewprep.LLD.messageQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicsRepository {



    Map<String,Topic> topicMap;

    public TopicsRepository() {
        this.topicMap = new HashMap<>();
    }

    public void addTopic(Topic topic) {
        this.topicMap.put(topic.getName(),topic);
    }

    public Topic getTopic(String topicName) {
        return this.topicMap.get(topicName);
    }

    public List<Topic> getAllTopics(){
        return new ArrayList<>(topicMap.values());
    }
}
