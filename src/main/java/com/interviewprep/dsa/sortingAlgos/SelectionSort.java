package com.interviewprep.dsa.sortingAlgos;

import static com.interviewprep.dsa.sortingAlgos.BubbleSort.print;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = new int[]{5,1,4,2,8};
        print(a);
        sort(a);
        print(a);
    }

    public static void sort(int[] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            int min_idx = i;
            for(int j=i+1;j<n-1;j++){
                if(a[min_idx] > a[j]){
                    min_idx = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_idx];
            a[min_idx] = temp;
        }
    }
}
