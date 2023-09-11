package com.interviewprep.DesignPattern.Observer;

public class AajTak implements Channel{

    private String news;
    @Override
    public void update(Object o) {
        this.news = (String)o;
        System.out.println("AajTak got this "+news);
    }
}
