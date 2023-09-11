package com.interviewprep.geeksforgeeks;

/**
 * Created by subhash on 23/10/20.
 */
public class MaximumDifference
{
    int maxDiff(int arr[], int arr_size)
    {
        int ans = arr[1]-arr[0];
        int minElement = arr[0];
        for(int i=0;i<arr_size;i++)
        {
            if(arr[i]-minElement > ans)
                ans = arr[i]-minElement;
            if(minElement>arr[i])
                minElement = arr[i];

        }
        return ans;
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        MaximumDifference maxdif = new MaximumDifference();
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        System.out.println("MaximumDifference is " +
                maxdif.maxDiff(arr, size));
    }
}