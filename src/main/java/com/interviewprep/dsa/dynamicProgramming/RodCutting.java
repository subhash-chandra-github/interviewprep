package com.interviewprep.dsa.dynamicProgramming;

public class RodCutting {




    public static int cutRod(int[] arr, int n){

        int[] val = new int[n+1];
        val[0] = 0;

        for(int i=1;i<=n;i++){
            int maxVal = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                maxVal = max(maxVal,arr[j]+val[i-j-1]);
            }
            val[i] = maxVal;

        }

        return val[n];

    }

    private static int max(int a, int b){
        return a>b?a:b;
    }
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }
}
