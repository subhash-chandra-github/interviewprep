package com.interviewprep.LLD.RateLimmiter;

import java.util.Date;

public class FixedBucketLimiter implements RateLimiter {

    private Date startTime;
    private int count;
    private final int maxCount;

    public FixedBucketLimiter(Date startTime, int count, int maxCount) {
        this.startTime = startTime;
        this.count = count;
        this.maxCount = maxCount;
    }

    @Override
    public boolean ingestRequest() {
        Date currentTime = new Date();
        if (currentTime.after(this.startTime)) {
            long diff = currentTime.getTime() - this.startTime.getTime();
            long seconds = diff / 1000;
            if (seconds >= 5) {
                this.startTime = currentTime;
                this.count = 1;
                System.out.println("Allowed " + currentTime + " count " + this.count);
                return true;
            }
            else if (seconds < 5) {
                if (this.count < this.maxCount) {
                    this.count++;
                    System.out.println("Allowed " + currentTime + " count " + this.count);
                    return true;
                } else {
                    System.out.println("Not Allowed " + currentTime + " count " + this.count);
                    return false;
                }
            }
        } else {
            System.out.println("Not Allowed ------");
            this.startTime = currentTime;
        }
        return false;
    }


    public static void main(String[] args) {

        RateLimiter rl = new FixedBucketLimiter(new Date(), 0, 5);

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            rl.ingestRequest();
        }
    }
}
