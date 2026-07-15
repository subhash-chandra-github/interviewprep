package com.interviewprep.solid.liskov.before;

public class Driver {

        public static void main(String[] args) {
            Bird sparrow = new Sparrow();
            Bird ostrich = new Ostrich();

            sparrow.fly(); // This works fine
            ostrich.fly(); // This throws an exception
        }
}
