package com.interviewprep.LLD.chess.entities;

import com.interviewprep.LLD.chess.enums.Color;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
