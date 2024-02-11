package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedCollection {

    private List<Integer> col;
    private Map<Integer,List<Integer>> indexesMap;
    private int size;
    public RandomizedCollection() {

        col  = new ArrayList<>();
        indexesMap = new HashMap<>();
        size = -1;
    }

    public boolean insert(int val) {
        col.add(val);
        size++;
        List<Integer> indexes =  indexesMap.getOrDefault(val,new ArrayList<>());
        indexes.add(size);
        indexesMap.put(val,indexes);
        return indexes.size() == 1;
    }


    public boolean remove(int val) {
        if(indexesMap.containsKey(val)){
            List<Integer> indexes = indexesMap.get(val);
            int index = indexes.get(indexes.size()-1);
            indexes.remove(index);
            int lastElement = col.get(size);
            col.set(index,lastElement);
            size--;
            if(indexes.size()==0){
                indexesMap.remove(val);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randIndex = (int) (Math.random()%size);
        return col.get(randIndex);

    }

    public static void main(String[] args) {

    }

}
