package com.brownj;

import java.util.ArrayList;

public class GameManager {

    private Bowler myBowler;
    private GameCard myCard;
    private Game myGame;
    private ArrayList<Bowler> myBowlers;
    private int bowlerIndex;
    private final int MAXBOWLERS = 99;
    private final int MINBOWLERS = 1;

    GameManager(int bowlers){
        this.bowlerIndex = bowlers;
        myBowlers = new ArrayList<Bowler>(bowlers);
        myCard = new GameCard();

    }

    void runGame() {
            //create Bowlers
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

//--------------------------------------------------------
    public void displayBowlers(){
        for(int i = 0; i < myBowlers.size(); i++){
            System.out.println("Bowler #" + myBowlers.get(i).getBowlerID());
        }
    }
//--------------------------------------------------------
    private void startGame(){
        myGame = new Game(myCard);

        myGame.beginGame(myBowlers);

    }
//--------------------------------------------------------
    public static void main(String[] args){

    }
}
