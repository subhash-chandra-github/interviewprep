package com.interviewprep.solid.liskov.after;

public class Driver {

        public static void main(String[] args) {
            FlyingBird sparrow = new Sparrow();
            Bird ostrich = new Ostrich();

            sparrow.fly(); // This works fine

            if (ostrich instanceof Ostrich) {
                ((Ostrich) ostrich).run(); // This works fine
            }
        }
}
