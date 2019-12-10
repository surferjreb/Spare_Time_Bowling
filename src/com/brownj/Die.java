package com.brownj;

import java.util.Random;

public class Die {
    private char[] dieValues;
    private final int MAXDIESIDES = 6;
    private final char pin = 'P';
    private final char blank = 'B';
    private final char spare = 'O';
    private Random rand;

    Die(){
        dieValues = new char[MAXDIESIDES];
        rand = new Random();
    }

    void setDie(int dieIndex, int maxIndex){
        int temp = rand.nextInt(MAXDIESIDES);
        int index = 0;

        for(int i = 0; i < MAXDIESIDES; i++){
            if(dieIndex < maxIndex - 1){
                if(i == temp){
                    dieValues[i] = pin;
                }
                else{
                    dieValues[i] = blank;
                }
            }
            else if(i == maxIndex - 1){
                if(temp == i){
                    dieValues[i] = pin;

                    index = setCircleDie(i);
                    dieValues[index] = spare;
                }
                else{
                    if(dieValues[i] != pin)
                        dieValues[i] = blank;
                }
            }
        }//end for
    }

    int getRollValue(){
        int temp = rand.nextInt(MAXDIESIDES);
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

    private int setCircleDie(int index){
        switch(index){
            case 1:
                        return index + 2;
            case 2:
                        return index + 2;
            case 3:
                        return index - 2;
            case 4:
                        return index - 2;
            case 5:
                        return index + 1;
            case 6:
                        return index - 1;
        }

        return -1;
    }

    public static void main(String[] args){
        Die myDie;
        ArrayList<Die>


        for(int i = 0; i < 10; i++) {
            myDie = new Die();
            myDie.setDie(i, 10);

        }

        int total = 0;

        for(int i = 0; i < MAXDICE; i++){
            myDie = myDice.get(i);
            total += myDie.getRollValue();

        }

        int pinsLeft = 10 -total;
        System.out.println("Pins left: " + pinsLeft + "Roll was: " + total);
    }
}//end class
