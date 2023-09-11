package com.interviewprep.sortingAlgos;

public class HeapSort {


    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void heapify(int i,int[] arr,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest !=i){
            swap(arr,largest,i);
            heapify(largest,arr,n);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,10,3,4,18,20,25};
        int n = arr.length;
        HeapSort maxHeap = new HeapSort();

        //build max heap
        for(int i = n/2-1;i>=0;i--){
            maxHeap.heapify(i,arr,n);
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        //sort
        for(int i=n-1;i>0;i--){
            maxHeap.swap(arr,0,i);
            maxHeap.heapify(0,arr,i);
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
