package com.interviewprep.coreJava;

public class SingletonClass {

   private SingletonClass(){};
    private static SingletonClass instance;
   // Eager
//    private static volatile SingletonClass instance = new SingletonClass();
//    public SingletonClass getInstacne(){
//        return instance;
//    }

    //Lazy
    public SingletonClass getInstacne(){
        if(instance==null){
            instance = new SingletonClass();
        }
        return instance;
    }

    //threadSafe

    public SingletonClass getInstanceTreadSafe(){
        if(instance==null){
            synchronized (SingletonClass.class) {
                if(instance==null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
