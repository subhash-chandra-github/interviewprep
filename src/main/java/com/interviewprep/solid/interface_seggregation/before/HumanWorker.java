package com.interviewprep.solid.interface_seggregation.before;

public class HumanWorker implements Worker{

    @Override
    public void work() {
        System.out.println("Human working");
    }

    @Override
    public void eat() {
        System.out.println("Human eating");
    }
}
