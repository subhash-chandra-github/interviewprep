package com.interviewprep.coreJava;

import java.lang.reflect.Field;

public class ReflectionTest {

    public static void main(String[] args) {

        try {

            // Student object created
            Class e = Class.forName("com.coreJava.Student");
            Object obj = e.newInstance();
        // Create Field object
            Field privateField
                    = e.getDeclaredField("name");

            // Set the accessibility as true
            privateField.setAccessible(true);
            privateField.set(obj,"Subhash");

            // Store the value of private field in variable
            String name = (String)privateField.get(obj);

            // Print the value
            System.out.println("Name of Student:" + name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
