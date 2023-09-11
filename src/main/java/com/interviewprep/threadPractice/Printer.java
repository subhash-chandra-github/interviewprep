package com.interviewprep.threadPractice;

/**
 * Created by subhash on 21/10/20.
 */
public class Printer {
    private static volatile boolean isOdd = true;
    private static final int MAX = 10;
    private static volatile int n = 1;

    public void printOdd() {
        synchronized (this) {
            while (n < MAX) {
                while (!isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n + " " + Thread.currentThread().getName());
                isOdd = false;
                n++;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (n < MAX) {
                while (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n + " " + Thread.currentThread().getName());
                isOdd = true;
                n++;
                notify();
            }
        }
    }
}
