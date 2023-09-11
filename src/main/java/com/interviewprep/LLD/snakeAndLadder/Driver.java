package com.interviewprep.LLD.snakeAndLadder;


import com.interviewprep.LLD.snakeAndLadder.Entities.Player;

public class Driver {

    public static void main(String[] args) {
        Game game= new Game(10);
        game.addPlayer(new Player(1,"A",0));
        game.addPlayer(new Player(2,"B",0));
        game.addPlayer(new Player(3,"C",0));
        game.launch();
    }
}
