package com.brownj;

import java.util.ArrayList;

public class Game {

    private ArrayList<Bowler> myBowlers;
    private Bowler myBowler;
    private Cup myCup;
    private GameCard myCard;
    private final int MAXFRAMES = 10;

    Game(GameCard myCard){
        myCup = new Cup();
        this.myCard = myCard;
    }

    void beginGame(ArrayList<Bowler> myBowlers){
        this.myBowlers = myBowlers;
        for(int i = 0; i < myBowlers.size(); i++){
            //get bowler
            for(int j = 0; j < MAXFRAMES; j++) {
                bowlerTurn(j, myBowlers.get(i));
            }

        }

        myCard.displayScoreSheet(myBowlers);
    }
//-------------------------------------------------------------
    private void bowlerTurn(int frameNumber, Bowler myBowler) {
        myBowler.setRolls(frameNumber, myCup);

    }
//-------------------------------------------------------------
//--------------------------------------------------------
    public static void main(String[] args){

    }
}//end class
