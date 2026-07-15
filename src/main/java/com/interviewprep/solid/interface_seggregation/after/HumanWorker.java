package com.interviewprep.solid.interface_seggregation.after;

public class HumanWorker implements Workable,Eatable{
    @Override
    public void work() {
        System.out.println("Human working");
    }

    @Override
    public void eat() {
        System.out.println("Human eating");
    }
}
