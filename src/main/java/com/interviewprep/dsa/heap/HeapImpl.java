package com.interviewprep.dsa.heap;

public class HeapImpl {

    public static int a[] = new int[100];
    public static int s = 0;

    public static void main(String[] args) {
        add(1);
        add(4);
        add(9);
        add(2);
        add(15);
        add(12);

        System.out.println(getMax());
        System.out.println(getMax());

    }
    public static void  add(int v){
        s++;
        int i = s-1;
        a[i] = v;

        int temp = a[i];
        a[i] = a[0];
        a[0] = temp;

        while(i>0 && a[i] > a[i/2]){

            temp = a[i];
            a[i] = a[i/2];
            a[i/2] = temp;

            i = i/2;
        }

    }

    public static int getMax(){
        int max = a[0];
        a[0] = a[s-1];
        s--;
        heapyfy(0);
        return max;
    }
    public static void heapyfy(int i){

        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;

        if(l>0 && l<s && a[i]<a[l]){
            largest = l;
        }
        if(r>0 && r<s && a[i]<a[r]){
            largest = r;
        }
        if(i!=largest){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapyfy(i);
        }
    }
}
