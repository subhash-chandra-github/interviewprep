package com.interviewprep.java8;

/**
 * Created by subhash on 20/10/20.
 */
@FunctionalInterface
public interface TestFunctionalInterface {
    void print(String s);
    //void make();

    public static void main(String[] args) {
        TestFunctionalInterface testFunctionalInterface = (String s)->{
            System.out.println(s);
        };
        testFunctionalInterface.print("Subhash");
    }
}
