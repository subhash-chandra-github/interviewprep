package com.interviewprep.coreJava;

public class StringManipulation {

    public static void main(String[] args) {
        String s = "Lat : 18.505 , Lng : 73.8176";
        String[] arrOfStr = s.split(",", 2);

        System.out.println("/Date(1643371208017)/".replaceAll("[^\\d]", ""));

        for (String a : arrOfStr)
            System.out.println(a.trim().replaceAll("[^\\d+.^\\d+]", ""));


        String dsd = "This  is,  a test,,,message";
        dsd = dsd.replace(',',' ').trim();
        dsd = dsd.replaceAll("\\s+", " ");
        System.out.println(dsd);
    }
}
