package com.interviewprep.threadPractice;

public class OddEven {

    private static final int max = 100;
    private volatile boolean isOdd = true;
    private volatile int n = 1;

    public synchronized void  printOdd(){
        while (n <= max) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(n + " " + Thread.currentThread().getName());
            n++;
            isOdd = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }


    public synchronized void printEven(){

            while (n <= max) {
                while (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(n + " " + Thread.currentThread().getName());
                n++;
                isOdd = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }

    public static void main(String[] args) throws InterruptedException {

        OddEven oddEven = new OddEven();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printOdd();
            }
        });
        t2.setName("Odd Thread");
        t1.setName("Even Thread");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finished");
    }
}
