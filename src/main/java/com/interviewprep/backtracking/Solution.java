package com.interviewprep.backtracking;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


class Solution{
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> lst = new ArrayList<>();
        List<Integer> o = new ArrayList<>(nums.length);

        for (int i: nums) {
            o.add(Integer.valueOf(i));
        }
        permuteHelper(o,lst);
        return result;

    }
    void permuteHelper(List<Integer> o, List<Integer> p ){
        if(o.size()==0){
            List<Integer> a = new ArrayList<>();
            a.addAll(p);
            result.add(a);
            return;
        }
        for(int i=0;i<o.size();i++)
        {
            int a = o.get(i);
            p.add(a);
            o.remove(i);
            permuteHelper(o,p);
            o.add(i,a);
            p.remove(p.size()-1);
        }
    }
    public static void main(String[] args) {
//        System.out.println("Subhash");
//        Solution s =  new Solution();
//        int[] nums = {1,2,3};
//        s.permute(nums);

        System.out.println(startMillis(1646073000000L));
    }

    static long startMillis(long millis){
        Date date = new Date(millis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }


}