package com.interviewprep.LLD.chess.entities;

import com.interviewprep.LLD.chess.enums.Color;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
