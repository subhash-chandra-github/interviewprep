package com.interviewprep.leetcode;

/**
 * Created by subhash on 29/1/21.
 */
public class DuplicateZero {
    public static void main(String args[])
    {
        int[] arr = new int[]{1,0,2,3,4,5,6};
        int n = arr.length;
        int j=1;
        int k = arr[j+1];
        arr[j+1]=arr[j];
        for(int i=j+2;i<n;i++)
        {
            int a = arr[i];
            arr[i]=k;
            k=a;
        }

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
