package com.interviewprep.LLD.message_queue.handler;

import com.interviewprep.LLD.message_queue.model.Consumer;
import com.interviewprep.LLD.message_queue.model.Topic;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (Consumer consumer:topic.getConsumers()) {
            startSubsriberWorker(consumer);
        }
    }

    public void startSubsriberWorker(@NonNull final Consumer topicSubscriber) {
        final String subscriberId = topicSubscriber.getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
