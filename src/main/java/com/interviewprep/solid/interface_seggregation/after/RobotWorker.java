package com.interviewprep.solid.interface_seggregation.after;

public class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
