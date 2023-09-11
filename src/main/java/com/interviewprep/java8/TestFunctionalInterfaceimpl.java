package com.interviewprep.java8;

/**
 * Created by subhash on 20/10/20.
 */
public class TestFunctionalInterfaceimpl {



    public static void main(String args[])
    {
        TestFunctionalInterface s = (String a)->{
            System.out.println("Hi "+a);
        };
        s.print("Subhash");
    }
}
