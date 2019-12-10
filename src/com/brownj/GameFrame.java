package com.brownj;

public class GameFrame {
    private int frameNumber;
    private int firstRoll;
    private int secondRoll;
    private int score;
    private int tenthFrameExtraScore;

    GameFrame(int frameNumber){
        this.frameNumber = frameNumber;
        tenthFrameExtraScore = 0;
    }
//----------------------------------------------------------
//get values
    String getFrameNumber(){
        return String.valueOf(frameNumber);
    }

    String getFirstRoll() {
        return String.valueOf(firstRoll);
    }

    String getSecondRoll() {
        return String.valueOf(secondRoll);
    }

    String getScore() {
        return String.valueOf(score);
    }

    String getTenthFrameScore(){
        return String.valueOf(tenthFrameExtraScore);
    }
//---------------------------------------------------------------
// set values
    void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    void setScore(int score) {
        this.score = score;
    }

    void setTenthFrameExtraScore(int diceRoll){
        this.tenthFrameExtraScore = diceRoll;
    }
//----------------------------------------------------------------

}
