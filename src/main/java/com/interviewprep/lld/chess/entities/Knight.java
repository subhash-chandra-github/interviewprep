package com.interviewprep.lld.chess.entities;

import com.interviewprep.lld.chess.enums.Color;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
