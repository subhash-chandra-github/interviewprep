package com.interviewprep.LLD.pub_sub_queue.model;

import com.interviewprep.LLD.pub_sub_queue.public_interface.ISubscriber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Consumer {
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public Consumer(@NonNull final ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
}
