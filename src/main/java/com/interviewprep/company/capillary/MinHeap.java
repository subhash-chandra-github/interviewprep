package com.interviewprep.company.capillary;

public class MinHeap extends Heaps {

    MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    void insert(int key) {     // 2  3
        if(size == capacity){
            System.out.println("Already full not able to insert key : "+key);
            return;
        }
        size++;
        int i=size-1;
        arr[i] = key;
        while(i!=0 && arr[i] < arr[parent(i)]){
            swap(i,parent(i));
            i=parent(i);
        }


    }

    @Override
    int remove() {

        int key = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapyfy(0);
        return key;

    }

    private void heapyfy(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(l<size && arr[smallest] > arr[l]){
            smallest=l;
        }
        if(r<size && arr[smallest] > arr[r]){
            smallest=r;
        }
        if(smallest!=i){
            swap(i,smallest);
            heapyfy(smallest);
        }
    }



}
