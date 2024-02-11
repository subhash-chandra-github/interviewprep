package com.interviewprep.dsa.recursion;

import java.io.*;


public class TestClass {
    public static void main(String[] args) throws IOException {

        System.out.println("Ans = "+ solve(31,32));
    }
    static long solve(int l, int r){
        // Your code goes here
        long sum = 0;
        for(int i=l;i<=r;i++){
            int m = 0;
            if(i<10){
                m = i*i;
            }else{
                m=i;
            }
            if(isButiful(m)){
                sum = sum+i;
            }
        }
        return sum;
    }

    static boolean isButiful(int n){
        if(n<10){
            if(n==1){
                return true;
            }
            return false;
        }
        int sum = 0;
        while(n!=0){
            int m = n%10;
            sum = sum + m*m;
            n = n/10;
        }
        return isButiful(sum);
    }

//    static int sumOfsquares(int n){
//        if(n<=3){
//            return n;
//        }
//        else{
//            int sum = 0;
//            while(n!=0){
//                sum = sum + (n%10);
//                n = n/10;
//            }
//            return sum;
//        }
//    }
}