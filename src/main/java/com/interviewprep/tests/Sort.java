package com.interviewprep.tests;


public class Sort {




    public void sort(String s){

        System.out.println("Inside sort method for Strings");

    }
    public void sort(Integer I){

        System.out.println("Inside sort method for Integer");

    }
    public void sort(Object o){

        System.out.println("Inside sort method for object");

    }

    public static void main(String[] args) {
        Sort sort = new Sort();
       // sort.sort(null);
    }
}
