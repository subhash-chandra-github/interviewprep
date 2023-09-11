package com.interviewprep.DesignPattern.ObserverJava;

import java.util.Observable;
import java.util.Observer;

public class AajTak implements Observer {

    private String news;

    @Override
    public void update(Observable observable, Object o) {

        this.news = (String) o;
        System.out.println("AajTak got this : "+news);
    }
}
