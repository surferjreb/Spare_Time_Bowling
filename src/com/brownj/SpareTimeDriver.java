package com.brownj;

public class SpareTimeDriver {

    public static void main(String[] args) {
        args = new String[1];

        CheckInput myCheck = new CheckInput();
        GameManager myGame;

        //test program
        args[0]= "2";

        try {
            if (myCheck.checkAmount(args)) {
                myGame = new GameManager(myCheck.getBowlerIndex());
                myGame.StartGame();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
