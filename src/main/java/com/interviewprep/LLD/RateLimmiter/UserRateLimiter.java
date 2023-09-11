package com.interviewprep.LLD.RateLimmiter;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimiter {

    private Map<String, FixedBucket> map;

    class FixedBucket {
        private Date startTime;
        private int count;
        private int maxCount;

        public FixedBucket(Date startTime, int count, int maxCount) {
            this.startTime = startTime;
            this.count = count;
            this.maxCount = maxCount;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMaxCount() {
            return maxCount;
        }

    }

    public UserRateLimiter() {
        this.map = new ConcurrentHashMap<>();
    }

    private void ingestRequest(String userId) {

        if (map.containsKey(userId)) {

            Date currentTime = new Date();
            FixedBucket bucket = map.get(userId);
            long diff = currentTime.getTime() - bucket.startTime.getTime();
            long seconds = diff / 1000;
            if (seconds <= 5) {
                if(bucket.count<bucket.maxCount) {
                    bucket.setCount(bucket.count + 1);
                    System.out.println(userId+ " Allowed at " + currentTime);
                }else{
                    System.out.println(userId+" Not Allowed at " + currentTime);
                }
            } else {
                bucket.setCount(1);
                bucket.setStartTime(currentTime);
                System.out.println(userId+ " Allowed at " + currentTime);
            }


        } else {
            Date startTime = new Date();
            FixedBucket fixedBucket = new FixedBucket(startTime, 1, 5);
            map.put(userId, fixedBucket);
            System.out.println(userId+" Allowed at " + startTime);
        }
    }

    public static void main(String[] args) {

        UserRateLimiter rl = new UserRateLimiter();
        for(int i=0;i<20;i++){
            if(i%2==0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            rl.ingestRequest("subhash");
            rl.ingestRequest("Lalit");
        }
    }
}
