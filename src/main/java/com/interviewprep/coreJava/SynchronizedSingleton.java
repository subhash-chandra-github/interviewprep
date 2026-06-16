package com.interviewprep.coreJava;

import java.io.Serializable;

public class SynchronizedSingleton implements Cloneable, Serializable {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        if (instance != null) {
            throw new RuntimeException("You have broken Singleton class!"); // Prevent reflections
        }
    }

    // synchronized — only one thread enters at a time
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            synchronized (SynchronizedSingleton.class) {
                if (null == instance) {
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }


    public Object readResolve() {   // Prevents Serialisation
        return instance;
    }

    @Override
    protected Object clone() // // Prevents cloning
            throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
