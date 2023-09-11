package com.interviewprep.coreJava;

public abstract class ParentAbstractClass {

    String a;
  ParentAbstractClass(){
      this.a = "Subhash";
  }

    void  print(){
        System.out.println("Hi i am abstract "+a);
    }

    abstract int add(int a, int b);
}
