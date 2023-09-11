package com.interviewprep.LLD.snakeAndLadder.Entities;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Integer,BoardEntity> cells;

    int cellCount;

    public Board(int dimension) {
        this.cellCount = dimension*dimension;
        cells = new HashMap<>();
        for(int i=0; i<dimension; i++) {
            int min = 2;
            int max = cellCount - 1;
            int start = (int) Math.floor(Math.random()*(max-min+1)+min);
            max = start - 1;
            int end = (int) Math.floor(Math.random()*(max-min+1)+min);
            if(!hasSnakeOrLadder(start)) {
                setEntity(start, new Snake(start, end));
            }
            max = cellCount - 1;
            end = (int) Math.floor(Math.random()*(max-min+1)+min);
            max = end - 1;
            start = (int) Math.floor(Math.random()*(max-min+1)+min);;
            if(!hasSnakeOrLadder(start)) {
                setEntity(start, new Ladder(start, end));
            }

        }
    }
    private void setEntity(int index, BoardEntity e) {
        cells.put(index, e);
    }


    public void print() {
        for(int i=cellCount; i>0; i--) {
            System.out.print(i+" ");
            if(hasSnakeOrLadder(i)) {
                System.out.print(cells.get(i).getString());
            }
            else {
                System.out.print("         ");
            }
            if(i%10 == 1) {
                System.out.println();
            }
        }
        System.out.println();

    }
    public BoardEntity getEntity(int index) {
        if(hasSnakeOrLadder(index)) {
            return this.cells.get(index);
        }
        return null;
    }
    public boolean hasSnakeOrLadder(int cellIndex) {
        return cells.containsKey(cellIndex);
    }
}
