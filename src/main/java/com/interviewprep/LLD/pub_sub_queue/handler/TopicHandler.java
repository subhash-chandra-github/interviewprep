package com.interviewprep.LLD.pub_sub_queue.handler;

import com.interviewprep.LLD.pub_sub_queue.model.Topic;
import com.interviewprep.LLD.pub_sub_queue.model.Consumer;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(@NonNull final Topic topic) {
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (Consumer consumer :topic.getSubscribers()) {
            startSubsriberWorker(consumer);
        }
    }

    public void startSubsriberWorker(@NonNull final Consumer consumer) {
        final String subscriberId = consumer.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, consumer);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
