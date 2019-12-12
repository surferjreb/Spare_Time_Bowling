package com.brownj;

import com.brownj.shotTaker.Cup;

import java.util.ArrayList;

public class Game {

    private GameFrame myFrame;
    private ArrayList<Bowler> myBowlers;
    private Bowler myBowler;
    private Cup myCup;
    private final int MAXFRAMES = 10;

    Game(){
        myCup = new Cup();
    }

    void runGame(ArrayList<Bowler> myBowlers){
        this.myBowlers = myBowlers;
        myCup.setDice();

        for(int i = 0; i < MAXFRAMES; i++){
            bowlerTurn(i);
        }

    }

    private void bowlerTurn(int frameNumber) {
        for (int j = 0; j < myBowlers.size(); j++) {
            if (frameNumber == 0) {

                myFrame = new GameFrame(frameNumber);

                myFrame.setFirstRoll(rollDice());
                myFrame.setSecondRoll(rollDice());
                myFrame.setScore(setFrameScore(myFrame));

                myBowlers.get(j).setFrame(myFrame);

        }
        else if (frameNumber > 0 && frameNumber < MAXFRAMES) {

                myFrame = new GameFrame(frameNumber);

                myFrame.setFirstRoll(rollDice());
                adjustFrameScore(Integer.parseInt(myFrame.getFirstRoll()), frameNumber, myFrame, j);
                myFrame.setSecondRoll(rollDice());
                myFrame.setScore(setFrameScore(myFrame));

                myBowlers.get(j).setFrame(myFrame);

        } else if (frameNumber == MAXFRAMES - 1) {

                myFrame = new GameFrame(frameNumber+1);

                myFrame.setFirstRoll(rollDice());
                adjustFrameScore(Integer.parseInt(myFrame.getFirstRoll()), frameNumber, myFrame, j);
                myFrame.setSecondRoll(rollDice());
                myFrame.setScore(setFrameScore(myFrame));

                int temp = rollDice();
                int score = Integer.parseInt(myBowlers.get(j).getFrameScore(frameNumber));
                myBowlers.get(j).setScore(frameNumber, calculateFinalScore(temp, score));

                myBowlers.get(j).setFrame(myFrame);

        }
    }
    }

    private int rollDice(){
        int temp = myCup.diceRoll();

        return temp;
    }

    private int setFrameScore(GameFrame myFrame){
        int score = Integer.parseInt(myFrame.getFirstRoll()) + Integer.parseInt(myFrame.getSecondRoll());

        return score;
    }

    private void adjustFrameScore(int firstRoll, int frameNumber, GameFrame myFrame, int bowlerIndex){
        int prevFrame = frameNumber - 1;
        int score = Integer.parseInt(myBowlers.get(bowlerIndex).getFrameScore(prevFrame));

        score += firstRoll;
        myBowlers.get(bowlerIndex).setScore(prevFrame, score);
    }
    private int calculateFinalScore(int lastFrameScore, int currentScore){
        lastFrameScore += currentScore;

        return lastFrameScore;
    }
}
