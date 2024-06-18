package com.interviewprep.designPattern.ObserverJava;


import java.util.Observable;

public class NewsAgency extends Observable {

    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }


    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        ZNews observer = new ZNews();
        AajTak aajTak = new AajTak();

        observable.addObserver(observer);
        observable.addObserver(aajTak);
        observable.setNews("Sun rises in the east");
    }
}