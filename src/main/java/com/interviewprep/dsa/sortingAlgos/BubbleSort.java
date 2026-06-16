package com.interviewprep.dsa.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {

        int[] a = new int[]{5,1,4,2,8};
        print(a);
       // iterative(a);
        recursive(a, a.length);
        print(a);
    }

    public static void iterative(int[] a){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void recursive(int[] a, int n) {
        if(n==1){
            return;
        }
        boolean swapped = false;
        for(int j=0;j<n-1;j++){
            if(a[j]>a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                swapped = true;
            }
        }
        if(!swapped){
            return;
        }
        recursive(a,n-1);
    }


    public static void print(int[] a){
        System.out.println(Arrays.toString(a));
    }
}
