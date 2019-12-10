package com.brownj

import java.util.Random;
import java.util.ArrayList;

public class Die {
    private ArrayList<Die> myDice;
    private char[] dieValues;
    private final int MAXDICE = 10;
    private final int MAXDICESIDES = 6;
    private final char pin = 'P';
    private final char blank = 'B';
    private final char spare = 'O';
    private Random rand;

    Die(){
        dieValues = new char[MAXDIESIDES];
        myDice = new ArrayList<>(MAXDICE);
        rand = new Random();
    }

    void setDice(){
        for(int i = 0; i < MAXDICE; i++){
            if(i < MAXDICE - 2){
                myDice.add(setDie());
            }
            else {
                myDice.add(setCircleDie());
            }

        }//end for
    }//end setDice();

    char[] setDie(){
        int temp = rand.nextInt(MAXDIESIDES);
        int index = 0;

        for(int i = 0; i < MAXDIESIDES; i++){

                if(i == temp){
                    dieValues[i] = pin;
                }
                else{
                    dieValues[i] = blank;
                }
            }
          }//end for

        return dieValues
    }

    int getRollValue(){
        int temp = rand.nextInt(6);
        int value = getDie(temp);

        return value;
    }

    private int getDie(int rollValue){

        for(int i = 0; i < dieValues.length; i++){
            if(i == rollValue){
                return getDieValue(dieValues[i]);
            }
        }

        return -1;
    }

    private int getDieValue(char value){

        switch(value){
            case 'B':
                    return 0;

            case 'O':
                    return 10;

            case 'P':
                    return 1;
        }

        return -1;
    }

    private char[] setCircleDie(){
        int temp = rand.nextInt(MAXDIESIDES);
        int index = 0;

        for(int i = 0; i < MAXDIESIDES; i++){

            if(i == temp){
                dieValues[i] = pin;
                dieValues[setCircle(i)] = spare;
            }
            else{
                if(dieValues[i] != spare)
                    dieValues[i] = blank;
            }//end if/else

        }//end for

        return dieValues;
    }//end setCircleDie()

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
    }//end setCircle

    public static void main(String[] args){
        Die myDie;
        ArrayList<Die> myDice;
        myDie = new Die();

            myDie.setDie();
            myDice.add(myDie);


        int total = 0;

        for(int i = 0; i < myDice.size(); i++){
            myDie = myDice.get(i);
            total += myDie.getRollValue();

        }

        int roll = 10 -total;
        System.out.println("Pins left: " + total + " Roll was: " + roll);
    }
}//end class
