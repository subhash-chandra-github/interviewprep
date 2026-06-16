package com.interviewprep.threadPractice;

public class OddEven {

    private static volatile int MAX = 100;
    private static volatile int n = 1;
    private static volatile boolean isOdd = true;

    public synchronized void printOdd() throws InterruptedException {
        while(n<MAX) {
            while (!isOdd) {
                wait();
            }
            System.out.println(n + " Printed by " + Thread.currentThread().getName());
            n++;
            isOdd = false;
            notify();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (n < MAX) {
            while (isOdd) {
                wait();
            }
            System.out.println(n + " Printed by " + Thread.currentThread().getName());
            n++;
            isOdd = true;
            notify();
        }
    }

    public static void main(String[] args) {

        OddEven obj = new OddEven();
        Thread t1 = new Thread(()->{
            try {
                obj.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                obj.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

    }

}
