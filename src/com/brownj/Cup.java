package com.brownj;

import java.util.ArrayList;
import java.util.Random;

public class Cup {
    private ArrayList<char[]> myDice;
    private ArrayList<Character> firstRoll;
    private ArrayList<Character> secondRoll;
    private Die myDie;
    private final int MAXDICE = 10;
    private final int MAXDIE = 6;
    private Random rand;
    private String score;

    Cup(){
        myDie = new Die();
        myDice = new ArrayList<>();
        myDice = myDie.getDice();
        firstRoll = new ArrayList<Character>(MAXDICE);
        secondRoll = new ArrayList<Character>(MAXDICE);
        rand = new Random();
                
    }

    public void runFirstRoll(){
        int roll = 0;

        try {
                if(!firstRoll.isEmpty()){
                    firstRoll.clear();
                }
                for (int i = 0; i < MAXDICE; i++) {
               
                    roll = rand.nextInt(6);
                    firstRoll.add(myDice.get(i)[roll]);

                }

            score = secondShotRoll(getRollPinCount(firstRoll));
        }
        catch(Exception e){
            e.printStackTrace();
        }

            
    }//end diceRoll()
//--------------------------------------------------    
    private String secondShotRoll(int pins){
      int roll = 0;
      int secondShot;
      int reRoll = 10 - pins;
      ArrayList<char[]> myReRoll = myDie.getRandomDice(reRoll);

        try {
            if(myReRoll.size() > 0) {

                for (int i = 0; i < reRoll; i++) {

                    roll = rand.nextInt(6);
                    if(!secondRoll.isEmpty()) {
                        secondRoll.clear();
                    }
                    secondRoll.add(myReRoll.get(i)[roll]);

                }
                secondShot = getRollPinCount(secondRoll);

                return checkForSpare(pins, secondShot);
            }//end if

            return checkForStrike(pins);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch

      return "-1";
    }//end secondRoll()
//---------------------------------------------------          
    ArrayList<Character> getFirstRoll(){
        return firstRoll;
    }
//---------------------------------------------------
    ArrayList<Character> getSecondRoll(){
        return secondRoll;
    }
//------------------------------------------------------
    int getRollPinCount(ArrayList<Character> myRoll){
        int pins = checkForO(myRoll);

        for(int i = 0; i < myRoll.size(); i++){

            if(myRoll.get(i) == 'B'){
                pins++;
            }

        }

        return pins;
    }
//------------------------------------------------------
    private int checkForO(ArrayList<Character> myRoll){

        if(myRoll.contains('O') && myRoll.contains('P'))
            return 1;

        return 0;
    }
//------------------------------------------------------
    private String checkForStrike(int pins){
        int totalPins = 10 - pins;

        if(totalPins == 10){
            return "X";
        }

        return String.valueOf(pins);
    }
//------------------------------------------------------
    private String checkForSpare(int firstShot, int secondShot){
        int totalPins = firstShot + secondShot;

        if(totalPins == 10){
            return String.valueOf(firstShot)+"/";
        }

        return String.valueOf(firstShot) + String.valueOf(secondShot);
    }
//------------------------------------------------------
    String getScore(){
        return score;
    }
//------------------------------------------------------
    public static void main(String[] args){
        Cup myCup = new Cup();

        myCup.runFirstRoll();
        String score = myCup.getScore();

        System.out.println("Score: "+ score);
        
    }

}//end class


