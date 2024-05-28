package com.interviewprep.LLD.message_queue.handler;

import com.interviewprep.LLD.message_queue.model.Consumer;
import com.interviewprep.LLD.message_queue.model.Message;
import com.interviewprep.LLD.message_queue.model.Topic;
import lombok.NonNull;
import lombok.SneakyThrows;

public class SubscriberWorker implements Runnable {

    private final Topic topic;
    private final Consumer consumer;

    public SubscriberWorker(@NonNull final Topic topic, @NonNull final Consumer topicSubscriber) {
        this.topic = topic;
        this.consumer = topicSubscriber;
    }
    @Override
    @SneakyThrows
    public void run() {
        synchronized (consumer) {
            do {
                int curOffset = consumer.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    consumer.wait();
                }
                Message message = topic.getMessages().get(curOffset);
                consumer.consume(message);
                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                consumer.getOffset().compareAndSet(curOffset, curOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (consumer) {
            consumer.notify();
        }
    }
}
