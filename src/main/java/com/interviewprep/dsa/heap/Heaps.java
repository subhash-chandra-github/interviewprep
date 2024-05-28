package com.interviewprep.dsa.heap;


public abstract class  Heaps {

    int capacity;
    int[] arr;
    int size;

    Heaps(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;

    }

    void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
    int parent(int i){
        return (i-1)/2;

    }
    int left(int i){
        return 2*i+1;
    }

    int right(int i){
        return 2*i+2;
    }

    abstract void insert(int n);

    abstract int remove();


    public static void main(String[] args) {

        Heaps maxHeap = new MaxHeap(5);

        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(2);

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());

        System.out.println("-------------------------------------------------");

        Heaps minHeap = new MinHeap(5);

        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(2);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
    }

}
