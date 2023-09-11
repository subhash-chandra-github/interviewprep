package com.interviewprep.LLD.chess.entities;

import com.interviewprep.LLD.chess.enums.Color;

public class Board {

    private Spot[][] spots;

    public void resetBoard() {
        spots[0][0] = new Spot(0, 0, new Rook(Color.WHITE));
        spots[0][1] = new Spot(0, 1, new Knight(Color.WHITE));
        spots[0][2] = new Spot(0, 2, new Bishop(Color.WHITE));
        //...
        spots[1][0] = new Spot(1, 0, new Pawn(Color.WHITE));
        spots[1][1] = new Spot(1, 1, new Pawn(Color.WHITE));
        //...

        // initialize black pieces
        spots[7][0] = new Spot(7, 0, new Rook(Color.BLACK));
        spots[7][1] = new Spot(7, 1, new Knight(Color.BLACK));
        spots[7][2] = new Spot(7, 2, new Bishop(Color.BLACK));
        //...
        spots[6][0] = new Spot(6, 0, new Pawn(Color.BLACK));
        spots[6][1] = new Spot(6, 1, new Pawn(Color.BLACK));
        //...

        // initialize remaining spots without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }
    }
    
    public Spot getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }
        return spots[x][y];
    }

}
