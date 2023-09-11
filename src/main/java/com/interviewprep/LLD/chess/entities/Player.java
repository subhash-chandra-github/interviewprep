package com.interviewprep.LLD.chess.entities;


import com.interviewprep.LLD.chess.enums.Color;

public class Player {

    private int id;
    private String name;

    private Color color;

    public Player(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
