package com.interviewprep.coreJava;

public class ChildA extends ParentAbstractClass{


    @Override
    int add(int a, int b) {
        return a+b;
    }

    private int mul(int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        ParentAbstractClass c1 = new ChildA();
        System.out.println(c1.add(5,6));
        //System.out.println(c1.mul(5,6));
        c1.print();

        ChildA c2 = new ChildA();
        System.out.println(c2.mul(5,6));
        c2.print();
    }
}
