package com.interviewprep.generics;


import java.util.List;

/**
 * Created by subhash on 28/1/21.
 */
public class Building {

    private String type;
    public void paint()
    {
       System.out.println(type+" Painted");
    }
    public Building(String type)
    {
        this.type=type;
    }

    public void paintAll(List<? extends Building> buildings)
    {
        for (Building b : buildings)
        {
            b.paint();
        }
    }
}
