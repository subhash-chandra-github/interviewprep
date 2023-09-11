package com.interviewprep.LLD.snakeAndLadder.Entities;

public class Snake extends BoardEntity{


    public Snake(int start, int end) {
        super(start, end);

    }

    @Override
    public String getEncounterMessage() {
        return "Ooops!! You encountered a Snake :( ";

    }

    @Override
    public String getString() {
        return "S("+this.getEnd()+")  ";
    }
}
