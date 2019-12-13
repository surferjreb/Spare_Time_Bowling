package com.brownj;

import java.util.ArrayList;

public class GameManager {

    private Bowler myBowler;
    private ArrayList<Bowler> myBowlers;
    private int bowlerIndex;
    private final int MAXBOWLERS = 99;
    private final int MINBOWLERS = 1;

    GameManager(int bowlers){
        this.bowlerIndex = bowlers;
        myBowlers = new ArrayList<Bowler>(bowlers);
        myBowler = new Bowler();

    }

    void StartGame(String bowlerAmount, GameCard myCard) {

            this.bowlerIndex = setBowlerIndex(bowlerAmount);
            this.myCard = myCard;
            //create Bowlers
            myBowlers = new ArrayList<>(bowlerIndex);
            createBowlers();
            displayBowlers();
            //start Game
            startGame();

    }
//--------------------------------------------------------
    private void createBowlers(){

        for(int i = 0; i < bowlerIndex; i++){
            myBowler = new Bowler(i);
            myBowlers.add(myBowler);
        }
    }
//--------------------------------------------------------
    private int setBowlerIndex(String bowlers){
        return Integer.parseInt(bowlers);
    }
//--------------------------------------------------------
    public void displayBowlers(){
        for(int i = 0; i < myBowlers.size(); i++){
            System.out.println("Bowler #" + myBowlers.get(i).getBowlerID());
        }
    }
//--------------------------------------------------------
    private void startGame(){
        myGame = new Game();

        myGame.runGame(myBowlers);

    }

}
