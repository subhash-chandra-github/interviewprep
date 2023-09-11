package com.interviewprep.LLD.snakeAndLadder.Service;

public class DiceService {


    public static int roll(){

        int min = 1;
        int max = 6;
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
