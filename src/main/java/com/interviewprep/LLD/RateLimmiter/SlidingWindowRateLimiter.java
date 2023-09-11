package com.interviewprep.LLD.RateLimmiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter implements RateLimiter{

    private final int maxCount;
    private final int windowSize;
    private final Queue<Long> q;

    public SlidingWindowRateLimiter(int maxCount, int windowSize) {
        this.maxCount = maxCount;
        this.windowSize = windowSize;
        this.q = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean ingestRequest() {
        long currentTime = System.currentTimeMillis();
        if(!q.isEmpty()) {
            long calculatedTime = (currentTime - q.peek()) / 1000;
            while (calculatedTime >= this.windowSize) {
                q.poll();
                if (q.isEmpty()) {
                    break;
                }
                calculatedTime = (currentTime - q.peek()) / 1000;
            }
        }
        if(q.size()<this.maxCount){
            q.add(currentTime);
            return true;
        }
        return false;

    }


}
