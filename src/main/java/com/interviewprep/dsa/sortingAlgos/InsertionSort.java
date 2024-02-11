package com.interviewprep.dsa.sortingAlgos;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 3, 5, 2, 5, 3, 0, 1,10,15};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);
    }

    void insertionSort(int[] a) {
        int[] b = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            for(int j = i-1;j>=0;j--) {
                if(a[i] < a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    i--;
                }
            }
        }
        System.out.println(a);
    }
}
