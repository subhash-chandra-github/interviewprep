package com.interviewprep.company.informatica;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhash on 31/10/2022.
 */
public class ExcutorTest {

    public static void main(String[] args) {

        //ExecutorService service = Executors.newFixedThreadPool(10);

        Map<Integer,String> mp = new HashMap<>();
        mp.put(1,"One");
        mp.put(2,"Two");
        mp.put(3,"Three");
        mp.put(4,"Four");
        mp.put(5,"Five");

        mp.forEach((key,value)->{
            if(key%2==1){
                System.out.println(value);
            }
        });

        mp.entrySet().stream().forEach(e->{
            if(e.getKey()%2==1){
                System.out.println(e.getValue());
            }
        });



    }
}
