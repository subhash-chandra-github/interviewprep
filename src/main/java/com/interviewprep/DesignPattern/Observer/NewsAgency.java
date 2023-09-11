package com.interviewprep.DesignPattern.Observer;


import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }


    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        ZNews observer = new ZNews();
        AajTak aajTak = new AajTak();

        observable.addObserver(observer);
        observable.addObserver(aajTak);
        observable.setNews("news");
    }
}