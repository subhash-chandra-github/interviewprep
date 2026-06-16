package com.interviewprep.dsa.sortingAlgos;

import static com.interviewprep.dsa.sortingAlgos.BubbleSort.print;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr  = new int[]{1, 3, 5, 2, 5, 3, 0, 1,10,15};
        print(arr);
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);
        System.out.println("After Sorting");
        print(arr);
    }

    void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i-1;
            while(j>=0 && a[j]>key){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j + 1] = key;
        }
    }
}
