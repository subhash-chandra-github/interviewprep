package com.interviewprep.threadPractice.oddEven;

/**
 * Created by subhash on 21/10/20.
 */
public class Thread1 extends Thread {

    Printer p;
    Thread1(Printer p)
    {
        this.p = p;
    }

    @Override
    public void run()
    {
        p.printEven();
    }


}
