package com.interviewprep.java8;

/**
 * Created by subhash on 20/10/20.
 */
public class ThreadPracticeRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());
    }
    public static void main(String args[]) {

        Thread t1 = new Thread(new ThreadPracticeRunnable(),"Thread-1____0");
        t1.start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Anonymous New thread created");
            }
        }).start();

        new Thread(()->
        System.out.println("Lamda New thread created")).start();
}
}
