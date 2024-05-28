package com.interviewprep.LLD.message_queue;

import com.interviewprep.LLD.message_queue.model.Consumer;
import com.interviewprep.LLD.message_queue.model.MQueue;
import com.interviewprep.LLD.message_queue.model.Message;
import com.interviewprep.LLD.message_queue.model.Topic;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        MQueue queue = new MQueue();
        Topic topic1 = queue.createTopic("t1");
        Topic topic2 = queue.createTopic("t2");

        Consumer sub1 = new Consumer("sub1", 10000);
        Consumer sub2 = new Consumer("sub2", 10000);
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub1,topic2);
        queue.subscribe(sub2, topic1);

        Consumer sub3 = new Consumer("sub3", 5000);
        queue.subscribe(sub3, topic2);

        queue.publish(topic1, new Message("m1"));
        queue.publish(topic1, new Message("m2"));

        queue.publish(topic2, new Message("m3"));

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4"));
        queue.publish(topic1, new Message("m5"));

    }
}
