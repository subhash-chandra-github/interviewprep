package com.interviewprep.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class Segregate0and1 {


   static void segregate012()
    {
        int[] arr = new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1,2,1,0,2,2,0,1,1,0};
        int n = arr.length;
        int l=0;
        int m=0;
        int h=n-1;
        int temp=0;
        while(m<=h)
        {
            switch (arr[m])
            {
                case 0:
                    temp = arr[l];
                    arr[l]=arr[m];
                    arr[m]=temp;
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    temp = arr[m];
                    arr[m]=arr[h];
                    arr[h]=temp;
                    h--;
                    break;
            }
        }
        int i;
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static void main(String[] args) {
//        int[] arr = new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1};
//        int l = arr.length;
//        int i = 0;
//        int j = arr.length - 1;
//        while (i < j) {
//            if (arr[i] == 1) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                j--;
//            } else {
//                i++;
//            }
//        }
//
//        for (i = 0; i < l; i++) {
//            System.out.print(arr[i] + " ");
//        }
        segregate012();
    }




}

