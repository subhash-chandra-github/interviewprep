package practice;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {

    public static void main(String[] args) {

        SubArraySumEqualToK obj = new SubArraySumEqualToK();
        int[] arr = new int[]{10, 2, -2, -20, 10};
        int count = obj.NoOfSubArraysSumEqualToK(arr,-10);
        System.out.println(count);

    }

    public int NoOfSubArraysSumEqualToK(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        int count=0;
        for(int i = 0; i < arr.length; i++){
            sum = sum+arr[i];
            if(mp.containsKey(sum-k)){
                count = count + mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
