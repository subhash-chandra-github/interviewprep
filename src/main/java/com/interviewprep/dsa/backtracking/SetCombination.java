package com.interviewprep.dsa.backtracking;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


class SetCombination {
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
        SetCombination s =  new SetCombination();
        int[] nums = {1,2,3};
        s.permute(nums);
        System.out.println(s.result.toString());

    }


}