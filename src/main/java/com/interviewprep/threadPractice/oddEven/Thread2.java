package com.interviewprep.threadPractice.oddEven;

/**
 * Created by subhash on 21/10/20.
 */
public class Thread2 extends Thread {

    Printer p;
    Thread2(Printer p)
    {
        this.p = p;
    }

    @Override
    public void run()
    {
        p.printOdd();
    }
}
