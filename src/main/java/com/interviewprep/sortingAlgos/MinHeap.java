package com.interviewprep.sortingAlgos;

public class MinHeap {
    int capacity;
    int[] arr;
    int heapSize;
    MinHeap(int capacity){
        this.capacity = capacity;
        this.heapSize = 0;
        this.arr = new int[capacity];
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }
    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void insert(int key){
        if(heapSize == capacity){
            System.out.println("Already full not able to insert key : "+key);
            return;
        }
        heapSize++;
        int i=heapSize-1;
        arr[i] = key;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(arr,i,parent(i));
            i = parent(i);
        }
    }

    private void heapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(l < heapSize && arr[smallest] > arr[l])
        {
            smallest = l;
        }
        if(r < heapSize && arr[smallest] > arr[r])
        {
            smallest = r;
        }
        if(smallest != i){
            swap(arr,i,smallest);
            heapify(smallest);
        }
    }

    private int extractMin(){
        if(heapSize <= 0){
            return Integer.MAX_VALUE;
        }
        if(heapSize == 1){
            heapSize--;
            return  arr[0];
        }
        int key = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;
        heapify(0);
        return key;
    }

    private void decreaseKey(int i,int val){
        arr[i] = val;
        while (i !=0 && arr[parent(i)] > arr[i]){
            swap(arr,i,parent(i));
            i = parent(i);
        }
    }

    private void deleteKey(int i){
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);
        heap.insert(2);
        heap.insert(5);
        heap.insert(0);
        heap.insert(8);
        heap.insert(4);
        int k = heap.extractMin();
        System.out.println(k);
        System.out.println("Smallest element : "+heap.arr[0]);
    }

}
