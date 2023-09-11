package com.interviewprep.LLD.chess.entities;

import com.interviewprep.LLD.chess.enums.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
