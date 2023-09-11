package com.interviewprep.LLD.RateLimmiter;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserBucketCreator {

    private Map<String,SlidingWindowRateLimiter> mp;

    public UserBucketCreator(String userId) {
        this.mp = new ConcurrentHashMap<>();
        mp.put(userId,new SlidingWindowRateLimiter(10,1));
    }

    private void getAccess(String userId){
               SlidingWindowRateLimiter windowRateLimiter =  mp.get(userId);
               if(windowRateLimiter.ingestRequest()){
                   System.out.println(Thread.currentThread().getName()+" Allowed at "+new Date());
               }else{
                   System.out.println(Thread.currentThread().getName()+" Not allowed at "+new Date());
               }
    }

    public static void main(String[] args) {
        UserBucketCreator bucketCreator = new UserBucketCreator("Subhash");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<12;i++){
            executorService.execute(()->bucketCreator.getAccess("Subhash"));
        }
        executorService.shutdown();
    }
}

