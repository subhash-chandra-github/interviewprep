package com.interviewprep.lld.chess.entities;

import com.interviewprep.lld.chess.enums.Color;

public class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
