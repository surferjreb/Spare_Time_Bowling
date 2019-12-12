package com.brownj.shotTaker;

import java.util.ArrayList;
import java.util.Random;

public class Cup {
    private ArrayList<char[]> myDice;
    private ArrayList firstRoll;
    private ArrayList secondRoll;
    private Die myDie;
    private final int MAXDICE = 10;
    private final int MAXDIE = 6;
    private Random rand;


    Cup(){
        myDie = new Die();
        myDice = myDie.getDice();
        firstRoll = new ArrayList(MAXDICE);
        secondRoll = new ArrayList(MAXDICE);
        rand = new Random();
                
    }

    public void runFirstRoll(){
        int roll = 0;

        try {
            for (int i = 0; i < MAXDICE; i++) {
               
                roll = rand.nextInt(6);
                       firstRoll.add(myDice.get(i)[roll]);

            }

            secondShotRoll(getRollPinCount(firstRoll));
        }
        catch(Exception e){
            e.printStackTrace();
        }

            
    }//end diceRoll()
//--------------------------------------------------    
    private void secondShotRoll(int pins){

      ArrayList<char[]> myReRoll = myDie.getRandomDice(pins);
      
      int roll = 0;

        try {
            for (int i = 0; i < pins; i++) {
               
                roll = rand.nextInt(6);
                       secondRoll.add(myReRoll.get(i)[roll]);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

      
    }//end secondRoll()
//---------------------------------------------------          
    ArrayList getFirstRoll(){
        return firstRoll;
    }
//---------------------------------------------------
    ArrayList getSecondRoll(){
        return secondRoll;
    }
//------------------------------------------------------
    int getRollPinCount(ArrayList myRoll){
        int pins = checkForO(myRoll);

        for(int i = 0; i < myRoll.size(); i++){

            if(myRoll.get(i).equals('P')){
                pins++;
            }

        }

        return pins;
    }
//------------------------------------------------------
    int getShotScore(ArrayList myRoll){

        int score = 0;

        for(int i = 0; i < myRoll.size(); i++){

            if(myRoll.get(i).equals('B')){
                score++;
            }

        }

       if(myRoll.contains('O') && !myRoll.contains('P'))
         score++;

        return score;
    }
    private int checkForO(ArrayList myRoll){

        if(myRoll.contains('O') && myRoll.contains('P'))
            return 1;

        return 0;
    }
//------------------------------------------------------
    public static void main(String[] args){
        Cup myCup = new Cup();
        ArrayList myRoll;
        ArrayList myRoll2;
        myCup.runFirstRoll();
        myRoll = myCup.getFirstRoll();

        for(int i = 0; i < 10; i++){
            
                System.out.print(myRoll.get(i) + ", ");
            
        }
        int temp = myCup.getRollPinCount(myRoll);
        int temp2 = myCup.getShotScore(myRoll);
        System.out.println("Pins left: " + temp + ", Shot score: " + temp2);
        System.out.println("\n");
        myCup.secondShotRoll(temp);
        myRoll2 = myCup.getSecondRoll();

        for(int i = 0; i < temp; i++){

            System.out.print(myRoll2.get(i) + ", ");

        }
        temp = myCup.getRollPinCount(myRoll2);
        temp2 = myCup.getShotScore(myRoll2);
        System.out.println();
        System.out.println("Pins left: " + temp + ", Shot score: " + temp2);
        System.out.println();
        
    }

}//end class


