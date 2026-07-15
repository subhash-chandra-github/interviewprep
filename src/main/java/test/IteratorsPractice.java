package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorsPractice {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<String, Integer>();

        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);

        // Getting an Iterator from map
        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + " : " + map.get(key));

            // This will reflect in iterator.
            // Hence, it has not created separate copy
            map.put("SEVEN", 7);
        }
        System.out.println("---------");
        map.forEach((key,value)->{
            System.out.println(key);
        });

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Kiwi");

        System.out.println("---------");
//        Iterator fit = fruits.iterator();
//        while(fit.hasNext()){
//            if(fit.next().equals("Apple")) {
//                fit.remove();
//            }
//        }
//
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(fruits);

        Iterator fit = copyOnWriteArrayList.iterator();
        while(fit.hasNext()){
            if(fit.next().equals("Apple")) {
                copyOnWriteArrayList.add("Guava");
            }
        }
        for(String fruit : copyOnWriteArrayList){
            System.out.println(fruit);
        }
    }
}
