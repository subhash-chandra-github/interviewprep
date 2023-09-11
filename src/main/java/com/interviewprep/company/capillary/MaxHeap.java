package com.interviewprep.company.capillary;


public class MaxHeap extends Heaps {


    MaxHeap(int capacity) {
        super(capacity);
    }

    @Override
    void insert(int key) {
        if(size == capacity){
            System.out.println("Already full not able to insert key : "+key);
            return;
        }
        size++;
        int i=size-1;
        arr[i] = key;
        while(i != 0 && arr[parent(i)] < arr[i]){
            swap(i,parent(i));
            i = parent(i);
        }

    }

    @Override
    int remove() {
        int n = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapyfy(0);
        return n;
    }

    private void heapyfy(int i){
        int l = left(i);
        int r =right(i);
        int largest = i;

        if(l>0 && l<size && arr[l] > arr[largest]){
            largest=l;
        }
        if(r>0 && r<size && arr[r] > arr[largest]){
            largest=r;
        }
        if(largest!=i){
            swap(largest,i);
            heapyfy(i);
        }
    }

}

