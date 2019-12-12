package com.brownj.shotTaker;

import java.util.ArrayList;

public class RollManager {
    private Cup myCup;
    private int firstShot;
    private int secondShot;
    private String score;

    RollManager(){
        Cup myCup = new Cup();
        this.firstShot = 0;
        this.secondShot = 0;
    }

    void runBowlersTurn(){
        int pinCount = 0;
        myCup.runFirstRoll();
        firstShot = myCup.getShotScore(myCup.getFirstRoll());

        if(!checkForStrike(firstShot))
        {
            pinCount = myCup.getRollPinCount(myCup.getFirstRoll());

            secondShot = myCup.getShotScore(myCup.getSecondRoll());
            if(!checkForSpare(firstShot, secondShot))
            {
                this.score = getFirstShot() + " | " + getSecondShot();
            }

        }
    }
//----------------------------------------------------------
    private boolean checkForSpare(int firstShot, int secondShot){
        int score = firstShot + secondShot;

        if(score == 10) {
            this.score = firstShot + "/";
            return true;
        }

        return false;
    }
//-----------------------------------------------------------

//-----------------------------------------------------------
    private boolean checkForStrike(int score){
        if(score == 10){
            this.score = "X";
            return true;
        }

        return false;
    }
//-----------------------------------------------------------

//-----------------------------------------------------------


//-----------------------------------------------------------

    String getFirstShot() {
        return String.valueOf(firstShot);
    }

    String getSecondShot() {
        return String.valueOf(secondShot);
    }
//------------------------------------------------
    String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    //------------------------------------------------
    public static void main(String[] args){


    }

//**lost and Found**
//private boolean checkPins(){
//    for(int i = 0; i < MAXDICE; i++){
//        for(int j = 0; j < 6; j++){
//            if(myDice.get(i)[j] == 'P'){
//                return true;
//            }
//        }
//    }
//
//    return false;
//}

//    private int getDieValue(char value){
//
//        switch(value){
//            case 'B':
//                return 0;
//
//            case 'O':
//                if(!checkPins()){
//                    return 0;
//                }
//
//                return 1;
//
//            case 'P':
//                return 1;
//        }
//
//        return -1;
}//end class
