package com.interviewprep.coreJava;

public class CoreJavaP {

    public static void main(String[] args) {

        int[] a = new int[]{5,8,2,1,6,0,9,3};
        int n = a.length;
        printArry(a);
        for(int i=n/2-1;i>=0;i--){
            heapify(a,n,i);
        }
        System.out.println();
        printArry(a);
        for(int i=n-1;i>0;i--){
            swap(a,i,0);
            heapify(a,i,0);
        }
//        for(int i=1;i<n;i++){
//            swap(a,i,n-1);
//            heapify(a,n-i,i);
//        }
        System.out.println();
        printArry(a);
    }

    private static void heapify(int a[], int n, int i){

        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;

        if(l<n && a[l]>a[largest]){
            largest = l;
        }
        if(r<n && a[r]>a[largest]){
            largest = r;
        }
        if(largest != i){
            swap(a,largest,i);
            heapify(a,n,largest);
        }
    }
    private static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void printArry(int[] a){
        for(int i:a){
            System.out.print(i+" ");
        }
    }

}
