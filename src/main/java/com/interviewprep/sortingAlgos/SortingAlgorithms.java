package com.interviewprep.sortingAlgos;

public class SortingAlgorithms {

    public void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Bubble Sort: ");
        printArray(arr);
    }

    public void selectionSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    int temp = min;
                    min = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Selection Sort: ");
        printArray(arr);
    }

    public void insertionSort(int[] arr, int n) {  // 1 3 5 9 -- 4,6,7
        for (int i = 1; i < n; i++) {
            int elementToBeInserted = arr[i];
            int j = i - 1;
            while (j >= 0 && elementToBeInserted < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = elementToBeInserted;
            printArray(arr);
        }
        System.out.print("Insertion Sort: ");
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private void mergeSort(int[] arr, int low, int high){
        if(low < high ) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j;
        for (i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[mid+1+ j];
        }
        i = 0;
        j = 0;
        int k = low;

        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i];
                i++;
            } else {
                arr[k++] = right[j];
                j++;
            }

        }
        while (i < n1) {
            arr[k++] = left[i];
            i++;
        }
        while (j < n2) {
            arr[k++] = right[j];
            j++;
        }

    }

    public void quickSort(int[] arr, int low,int high){
        if(low<high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p + 1, high);
        }
    }
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int[] arr,int low, int high){
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){

            if(arr[j]<pivot){ // 5,6,2,1,8,7,4 => 2,1,4,8,7,5,6
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;

    }

    private void heapify(int arr[],int i, int n){

        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[smallest]>arr[left]){
            smallest = left;
        }
        if(right<n && arr[smallest]>arr[right]){
            smallest = right;
        }
        if(i!=smallest){
            swap(arr,i,smallest);
            heapify(arr,smallest,n);
        }
    }

    private void heapSort(int arr[], int n){

        for(int i = n/2-1;i>=0;i--){
            heapify(arr,i,n);
        }

        for(int i=n-1;i>0;i--){
            swap(arr,i,0);

            heapify(arr,0,i);
        }
    }

    public static void main(String[] args) {
        SortingAlgorithms sort = new SortingAlgorithms();
        int[] arr = new int[]{5,6,3,2,1,13};
        int n = arr.length;
//        sort.bubbleSort(arr, n);
//        sort.selectionSort(arr, n);
        sort.insertionSort(arr, n);

//        sort.mergeSort(arr,0,n-1);
//        System.out.print("Merge Sort: ");
//        sort.printArray(arr);
//
//        sort.quickSort(arr,0,n-1);
//        System.out.print("Quick Sort: ");
//        sort.printArray(arr);
//
//        System.out.print("HeapSort :");
//        sort.heapSort(arr,n);
//        sort.printArray(arr);
    }
}
