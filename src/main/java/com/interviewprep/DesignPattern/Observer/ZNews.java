package com.interviewprep.DesignPattern.Observer;

public class ZNews implements Channel{


    private String news;

    @Override
    public void update(Object o) {

        this.news = (String)o;
        System.out.println("znews got this "+news);

    }
}
