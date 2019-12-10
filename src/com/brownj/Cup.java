package com.brownj;

import java.util.ArrayList;

public class Cup {
    private ArrayList<Die> myDice;
    private Die myDie;
    private final int MAXDICE = 10;
    private int roll;

    Cup(){
        myDice = new ArrayList<>(MAXDICE);
    }

    public void setDice(){
        for(int i = 0; i < MAXDICE; i++){
            myDie = new Die();
            myDie.setDie(i, MAXDICE);
            myDice.add(myDie);
        }
    }

    public int diceRoll(){
        int total = 0;

        for(int i = 0; i < MAXDICE; i++){
           myDie = myDice.get(i);
           total += myDie.getRollValue();

        }

        return total;
    }
}
