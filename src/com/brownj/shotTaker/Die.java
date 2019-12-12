package com.brownj.shotTaker;

import java.util.Random;
import java.util.ArrayList;

public class Die {
    private ArrayList<char[]> myDice;
    
    private final int MAXDICE = 10;
    private final int MAXDICESIDES = 6;
    private final char pin = 'P';
    private final char blank = 'B';
    private final char spare = 'O';
    private Random rand;

    Die(){
        myDice = new ArrayList<>(MAXDICE);
        rand = new Random();
        setDice();
    }

    private void setDice(){
        for(int i = 0; i < MAXDICE; i++){
            if(i < MAXDICE - 1){
               myDice.add(setDie());
            }
            else {
                
                myDice.add(setCircleDie());
            }

        }//end for
    }//end setDice();
//-------------------------------------------------------
    private char[] setDie(){
        int temp = rand.nextInt(MAXDICESIDES);
        char[] die = new char[MAXDICESIDES];

        for(int i = 0; i < MAXDICESIDES; i++){

                if(i == temp){
                    die[i] = pin;
                }
                else{
                    die[i] = blank;
                }
            }//end for
      return die;
    }//end method
//-------------------------------------------------------
    ArrayList<char[]> getRandomDice(int dieAmount){
        int temp = 0;
        ArrayList<char[]> myNewDice = new ArrayList<>(dieAmount);


        for(int i = 0; i < dieAmount; i++){
            temp = rand.nextInt(MAXDICE - 1);

            if(!myDice.contains(myDice.get(temp))) {
                myNewDice.add(myDice.get(temp));
            }
            else{
                myNewDice = getNewRandomDie(myNewDice);
            }
        }

        return myNewDice;
    }
//-------------------------------------------------------
    private ArrayList<char[]> getNewRandomDie(ArrayList<char[]> myNewDice){
    int temp = 0;

        temp = rand.nextInt(MAXDICE - 1);

        if(!myNewDice.contains(myDice.get(temp))) {
            myNewDice.add(myDice.get(temp));
        }
        else{
            myNewDice = getNewRandomDie(myNewDice);
        }

    return myNewDice;
}
//-------------------------------------------------------
    private char[] setCircleDie(){
        int temp = rand.nextInt(MAXDICESIDES);
        char[] die = new char[MAXDICESIDES];

        for(int i = 0; i < MAXDICESIDES; i++){

            if(i == temp){
                die[i] = pin;
                die[setCircle(i)] = spare;
            }
            else{
                if(die[i] != spare)
                    die[i] = blank;
            }//end if/else

        }//end for
      return die;
    }//end setCircleDie()
//-------------------------------------------------------
    private int setCircle(int index){

        switch(index){
            case 0:
                return index + 2;
            case 1:
                return index + 2;
            case 2:
                return index - 2;
            case 3:
                return index - 2;
            case 4:
                return index + 1;
            case 5:
                return index - 1;
        }//end switch
        
        return 0;
    }//end setCircle
//-------------------------------------------------------
    ArrayList getDice(){
        return myDice;
    }
//-------------------------------------------------------
    public static void main(String[] args){
        Die myDie;
        ArrayList<char[]> myDice;
        myDie = new Die();
        char[] die;
        myDice = myDie.getDice();
        
        for(int i = 0; i < myDice.size(); i++){
        System.out.print("Die #" + i + " ");
            for(int j = 0; j < 6; j++){
               System.out.print(myDice.get(i)[j] + ", ");
            }
            
            System.out.println();
        }
    }
}//end class
