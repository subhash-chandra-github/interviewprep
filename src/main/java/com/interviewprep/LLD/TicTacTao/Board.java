package com.interviewprep.LLD.TicTacTao;

public class Board {

    private final char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                    this.cells[i][j]='-';
            }
        }
    }

    public void print(){
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){

                System.out.print(cells[i][j]+" ");
            }
            System.out.println();
        }
    }

    public char[][] getCells() {
        return cells;
    }
}
