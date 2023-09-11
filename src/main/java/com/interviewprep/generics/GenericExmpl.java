package com.interviewprep.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhash on 26/10/20.
 */
public class GenericExmpl<T> {

    T obj;
    GenericExmpl(T obj)
    {
        this.obj=obj;
    }

    public T getObj()
    {
        return this.obj;
    }

    public static void main(String[] args) {
        GenericExmpl<String> genericExmpl = new GenericExmpl<>("Generic Example");
        System.out.println(genericExmpl.getObj());

        GenericExmpl<Integer> genericExmpl0 = new GenericExmpl<>(560);
        System.out.println(genericExmpl0.getObj());

        Home home = new Home("Home");
        Home school = new Home("School");
        List<Home> buildings = new ArrayList<>();
        buildings.add(home);
        buildings.add(school);

        Building b = new Building("Super");
        b.paintAll(buildings);

    }
}
