package com.interviewprep.solid.liskov.after;

import com.interviewprep.solid.liskov.before.Bird;

public class FlyingBird extends Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}
