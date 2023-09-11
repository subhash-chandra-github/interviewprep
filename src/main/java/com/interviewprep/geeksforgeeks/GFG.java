package com.interviewprep.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class GFG {

    void maxDiff(int[] arr, int n){
        int maxDiff = Integer.MIN_VALUE;
        int minElement = arr[0];
        for(int i=1;i<n;i++){
            if((arr[i]-minElement) > maxDiff)
                maxDiff = arr[i]-minElement;
            if(arr[i]<minElement){
                minElement = arr[i];
            }
        }
        System.out.println(maxDiff);
    }

    void kdane(int[] arr,int n){
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curr = curr + arr[i];
            if(max<curr){
                max = curr;
            }
            if(curr < 0){
                curr = 0;
            }
        }
        System.out.println(max);
    }
    //{2,0,2,8,9,7,3}
    void targetSum(int[] arr, int n, int target){

        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int k = target-arr[i];
            if(mp.containsKey(arr[i])){
                System.out.println("Found "+i+" "+mp.get(arr[i]));
            }else{
                mp.put(k,i);
            }
        }

    }



    public static void main(String[] args) {
        int[] arr = new int[]{5,0,2,8,9,7,3};
        GFG gfg = new GFG();
//        gfg.maxDiff(arr,arr.length);
//        gfg.kdane(arr,arr.length);
 //       gfg.targetSum(arr,arr.length,7);
    }
}
