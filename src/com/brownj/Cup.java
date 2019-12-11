package com.brownj;

import java.util.ArrayList;
import java.util.Random;

public class Cup {
    private ArrayList<char[]> myDice;
    private ArrayList firstRoll;
    private ArrayList secondRoll;
    private Die myDie;
    private final int MAXDICE = 10;
    private Random rand;
    private int pinCount;
    private int pinsLeft;
    private String score;

    Cup(){
        myDie = new Die();
        myDice = myDie.getDice();
        firstRoll = new ArrayList(MAXDICE);
        secondRoll = new ArrayList(MAXDICE);
        rand = new Random();
        pinCount = 0;
        pinsLeft = 0;
        
    }

    public void diceRoll(){
        int roll = 0;
        int pins = 0;
        char temp;
        
        for(int i = 0; i < MAXDICE; i++){
            roll = rand.nextInt(6);
            for(int j = 0; j < 6; j++){
                firstRoll.add(myDice.get(i)[roll]);
            }

        }
        
        if(checkForStrike(firstRoll)){
            score = "X";
            }
        else{
            for(int i = 0; i < firstRoll.size(); i++){
               temp = String.valueOf(firstRoll.get(i)).charAt(0);
               pins += getDieValue(temp);
            }
            
            secondShotRoll(pins);
        }   
            
    }//end diceRoll()
//--------------------------------------------------    
    private void secondShotRoll(int pins){
      myDie = new Die();
      myDice = myDie.getDice();
      int roll = 0;
      int pinCount = 0;
      int firstShot = pins;
      
      for(int i = 0; i < pins; i++){
         roll = rand.nextInt(6);
         for(int j = 0; j < 6; j++){
            secondRoll.add(myDice.get(i)[roll]);
         }
         
      }
      pinCount = countPins(secondRoll);
      
      if(checkForSpare(pins, pinCount)){
           score = firstShot + " /";
      }
      else{
          
          score = String.valueOf(firstShot + pinCount);
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
//---------------------------------------------------
    private boolean checkForStrike(ArrayList myPins){
        for(int i = 0; i < myPins.size(); i++){
            if(myPins.get(i).equals('P'))
               return false;
        }
        
        return true;
    }
//----------------------------------------------------------    
    private int getDieValue(char value){

        switch(value){
            case 'B':
                return 0;

            case 'O':
                  if(!checkPins()){
                     return 0;
                  }
                  
                     return 1;
                     
            case 'P':
                return 1;
        }

        return -1;
    }//end method
//------------------------------------------------------    
    private boolean checkPins(){
      for(int i = 0; i < MAXDICE; i++){
         for(int j = 0; j < 6; j++){
            if(myDice.get(i)[j] == 'P'){
               return true;
            }
         }
      }
      
      return false;
    }
//------------------------------------------------------    
    private boolean checkForSpare(int firstShot, int secondShot){
      int temp = firstShot + secondShot;
      
      if(temp == 10)
         return true;
         
      return false;   
    }
//------------------------------------------------------    
    private int countPins(ArrayList secondRoll){
      int pins = 0;
      char temp;
      
      for(int i = 0; i < secondRoll.size(); i++){
      temp = String.valueOf(secondRoll.get(i)).charAt(0);
         if(temp == 'P')
            pins += getDieValue(temp);
      }
      
      return pins;
    }
//------------------------------------------------------
    public static void main(String[] args){
        Cup myCup = new Cup();
        ArrayList myRoll;

        myCup.diceRoll();
        myRoll = myCup.getFirstRoll();

        for(int i = 0; i < 10; i++){
            System.out.print(myRoll.get(i) + ", ");
        }

        System.out.println();

    }

}//end class


