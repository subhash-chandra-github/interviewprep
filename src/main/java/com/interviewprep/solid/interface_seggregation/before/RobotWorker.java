package com.interviewprep.solid.interface_seggregation.before;

public class RobotWorker implements Worker{

    @Override
    public void work() {
        System.out.println("Robot working");
    }

    @Override
    public void eat() {
        // Robot does not eat, but we have to implement this method because of the interface
        throw new UnsupportedOperationException("Robot does not eat");
    }
}
