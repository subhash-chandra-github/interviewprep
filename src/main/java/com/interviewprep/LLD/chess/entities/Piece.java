package com.interviewprep.LLD.chess.entities;


import com.interviewprep.LLD.chess.enums.Color;

public abstract class Piece {

    private Color color;
    private boolean isKilled = false;

    public abstract boolean canMove(Board board,
                                    Spot start, Spot end);

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
