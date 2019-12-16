package com.brownj;

import java.util.ArrayList;

public class Bowler {
    private final int MAXFRAMES = 10;
    private int bowlerId;
    private ArrayList<String> frameScore;



    Bowler(int bowlerID) {
        bowlerId = bowlerID;
        frameScore = new ArrayList<>(MAXFRAMES);
        
    }
//-------------------------------------------------------
    void setScore(int frameNumber, String scoreSymbol){
        frameScore.add(frameNumber, scoreSymbol);
    }
//-------------------------------------------------------
    ArrayList<String> getFrameScore(){
        return frameScore;
    }
//-------------------------------------------------------
    private void setFinalScore(int frameNumber, String scoreSymbol, Cup myCup){
        if(frameNumber == MAXFRAMES - 1){
            if(scoreSymbol.equals("X")){
                myCup = new Cup();
                myCup.runFirstRoll();
                scoreSymbol = scoreSymbol + myCup.getScore();

                if(scoreSymbol.equals("XX")){
                    myCup = new Cup();
                    myCup.runFirstRoll();
                    scoreSymbol = scoreSymbol + myCup.getScore().charAt(0);

                } 

            }
            else if(scoreSymbol.charAt(1) == '/'){
               myCup = new Cup();
               myCup.runFirstRoll();
                scoreSymbol = scoreSymbol + myCup.getScore().charAt(0);
            }
            frameScore.add(frameNumber, scoreSymbol);
        }
    }
//-------------------------------------------------------
    void setRolls(int frameNumber, Cup myCup){

        String scoreSymbol;

        myCup.runFirstRoll();
        scoreSymbol = myCup.getScore();
        if(frameNumber < MAXFRAMES - 1) {
            setScore(frameNumber, scoreSymbol);
        }
        else{
            setFinalScore(frameNumber, scoreSymbol, myCup);
        }
    }
//-------------------------------------------------------
    String getBowlerID(){

        return String.valueOf(bowlerId + 1);
    }
//--------------------------------------------------------
    public static void main(String[] args){
        Bowler myBowler = new Bowler(0);
        GameCard myCard = new GameCard();
        Game myGame = new Game(myCard);
        ArrayList<Bowler> myBowlers = new ArrayList<>(2);

        myBowlers.add(myBowler);

        myGame.beginGame(myBowlers);



    }
}
