package com.interviewprep.LLD.TicTacTao;

public class Player {

    private int id;
    private String name;
    private Character symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Player(int id, String name, Character symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }
}
