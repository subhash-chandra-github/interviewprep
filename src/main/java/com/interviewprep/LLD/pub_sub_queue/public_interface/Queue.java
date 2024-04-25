package com.interviewprep.LLD.pub_sub_queue.public_interface;


import com.interviewprep.LLD.pub_sub_queue.handler.TopicHandler;
import com.interviewprep.LLD.pub_sub_queue.model.Message;
import com.interviewprep.LLD.pub_sub_queue.model.Topic;
import com.interviewprep.LLD.pub_sub_queue.model.Consumer;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String, TopicHandler> topicProcessors;

    public Queue() {
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(@NonNull final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void subscribe(@NonNull final ISubscriber subscriber, @NonNull final Topic topic) {
        topic.addSubscriber(new Consumer(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(@NonNull final Topic topic, @NonNull final Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(@NonNull final Topic topic, @NonNull final ISubscriber subscriber, @NonNull final Integer newOffset) {
        for (Consumer consumer : topic.getSubscribers()) {
            if (consumer.getSubscriber().equals(subscriber)) {
                consumer.getOffset().set(newOffset);
                System.out.println(consumer.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubsriberWorker(consumer)).start();
                break;
            }
        }
    }
}
