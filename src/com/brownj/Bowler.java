package com.brownj;

import java.util.ArrayList;

public class Bowler {
    private final int MAXFRAMES = 10;
    private int bowlerId;
    private ArrayList<GameFrame> frameScore;
    private int finalScore;


    Bowler(int bowlerId){
        this.bowlerId = bowlerId;
        frameScore = new ArrayList(MAXFRAMES);
        this.finalScore = 0;

    }
//-------------------------------------------------------
//set values
    void setScore(int frame, int score){
        frameScore.get(frame).setScore(score);
    }

    void setFinalScore(){
        int score = 0;

        for(int i = 0; i < MAXFRAMES; i++){

            score = Integer.parseInt(frameScore.get(i).getScore());
            finalScore += score;
        }

    }

    void setFrame(GameFrame myFrame){
        frameScore.add(myFrame);
    }
//-------------------------------------------------------
//get values
    String getFrameScore(int frameNumber){
        return frameScore.get(frameNumber).getScore();
    }

    String getFinalScore(){
        return String.valueOf(finalScore);
    }

    String getBowlerID(){

        return String.valueOf(bowlerId + 1);
    }
//--------------------------------------------------------
}
