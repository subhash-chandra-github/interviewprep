package com.interviewprep.LLD.pub_sub_queue.handler;

import com.interviewprep.LLD.pub_sub_queue.model.Message;
import com.interviewprep.LLD.pub_sub_queue.model.Topic;
import com.interviewprep.LLD.pub_sub_queue.model.Consumer;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;

@Getter
public class SubscriberWorker implements Runnable {

    private final Topic topic;
    private final Consumer consumer;

    public SubscriberWorker(@NonNull final Topic topic, @NonNull final Consumer consumer) {
        this.topic = topic;
        this.consumer = consumer;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (consumer) {
            do {
                int curOffset = consumer.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    consumer.wait();
                }
                Message message = topic.getMessages().get(curOffset);
                consumer.getSubscriber().consume(message);

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
