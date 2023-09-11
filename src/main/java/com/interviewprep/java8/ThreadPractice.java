package com.interviewprep.java8;

/**
 * Created by subhash on 20/10/20.
 */
public class ThreadPractice extends Thread{

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String args[])
    {
        ThreadPractice tp = new ThreadPractice();
        tp.start();
        ThreadPractice tp2 = new ThreadPractice();
        tp2.start();

    }
}
