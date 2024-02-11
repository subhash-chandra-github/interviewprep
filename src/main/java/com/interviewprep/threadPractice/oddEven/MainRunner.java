package com.interviewprep.threadPractice.oddEven;

/**
 * Created by subhash on 21/10/20.
 */
public class MainRunner {

    public static void main(String[] args) {
        Printer p = new Printer();
        Thread1 odd = new Thread1(p);
        Thread2 even = new Thread2(p);
            odd.start();
            even.start();
    }
}
