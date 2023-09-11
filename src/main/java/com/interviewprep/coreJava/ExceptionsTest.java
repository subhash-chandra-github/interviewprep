package com.interviewprep.coreJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionsTest {

    //Checked Exceptions -- compile time exceptions
    //1. FileNotFoundException
    //2. InterruptedException
    //3.ClassNotFoundException
    //4.InstantiationException
    public void readFile() throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String fileName = "file does not exist";
        File file = new File(fileName);
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        Class e = Class.forName("com.coreJava.Student");
        Object obj = e.newInstance();
    }


    //unchecked exceptions -- runtime exceptions
    // NullPointer exceptions
    // ArrayIndexOutOfBound exceptions
    //Arithmetic exceptions
    public static void main(String[] args) {

        try{
            int b = 5/0;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
