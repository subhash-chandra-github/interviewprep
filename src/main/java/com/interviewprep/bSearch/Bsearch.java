package com.interviewprep.bSearch;

public class Bsearch {

    public static void main(String[] args) {
        int[] arr = new int[]{7,8,9,1,2,4,5,6};
        System.out.println(findPivot(arr,0, arr.length-1));
    }


    static int findPivot(int[] arr, int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }
}
