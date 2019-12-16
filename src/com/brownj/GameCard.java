package com.brownj;

import java.util.ArrayList;

public class GameCard {
    private Bowler myBowler;
    private final int MAXFRAMES = 10;
    private ArrayList<String> totalScore;
    private ScoreCard scoreCard;

    GameCard(){
        totalScore = new ArrayList<>(MAXFRAMES);
        scoreCard = new ScoreCard();
    }

    void displayScoreSheet(ArrayList<Bowler> myBowlers){
            printScoreSheetHeader();
            displayBowler(myBowlers);
    }

    void printScoreSheetHeader(){
        System.out.print("NAME" + "|");
        for(int i = 0;  i < MAXFRAMES; i++){
            if(i < MAXFRAMES - 1){
               System.out.print("  " + (i+1) +"  |");
            }
            else{
               System.out.print(" " + (i+1) + "  |");
            }
        }
        System.out.println();
        System.out.print("----+");
        for(int i = 0; i < MAXFRAMES; i++){
            if(i < MAXFRAMES-1) {
                System.out.print("-----+");
            }
            else{
                System.out.print("-----|");
            }
        }
        System.out.println();
    }
//-----------------------------------------------------------------
    private void displayBowler(ArrayList<Bowler> myBowlers){
        for(int i = 0; i < myBowlers.size(); i++){
            this.myBowler = myBowlers.get(i);
            displayFrameScoreSymbol(myBowler);
            displayScore(myBowler);
        }

    }
//-----------------------------------------------------------------
    private void displayFrameScoreSymbol(Bowler myBowler){
        String score;
        System.out.print("| * |");
        for(int i = 0; i < MAXFRAMES; i++){
            score = myBowler.getFrameScore().get(i);

            if(i < MAXFRAMES - 1) {
                if(score.length() < 2) {
                    System.out.print(" |" + score + "| |");
                }
                else{
                    System.out.print(" |" + score.charAt(0) +"|"+
                            score.charAt(1)+"|");
                }
            }
            else{
                if(score.length() == 3) {
                    System.out.println(score.charAt(0) +"|" + score.charAt(1) +
                            "|" + score.charAt(2) + "|");
                }
                else{
                    System.out.println(score.charAt(0) + "|" + score.charAt(1) +
                            "  |");
                }
            }
        }
    }
//-----------------------------------------------------------------
    private void displayScore(Bowler myBowler){
        String bowlerID = myBowler.getBowlerID();

        setScore(myBowler);

        if(bowlerID.length() > 2) {
            System.out.print("|#" + bowlerID + "|");
        }
        else{
            System.out.print("|#" + bowlerID + " |");
        }

        for(int i = 0; i < MAXFRAMES; i++){
            switch(getScore(i).length()){
                case 1:
                    System.out.print("  " + getScore(i) + "  |");
                    break;
                case 2:
                    System.out.print("  " + getScore(i) + " |");
                    break;
                case 3:
                    System.out.print(" " + getScore(i) + " |");
            }
        }
        System.out.println();
    }
//-----------------------------------------------------------------
    void setScore(Bowler myBowler){

        totalScore = scoreCard.scoreCard(myBowler.getFrameScore());

    }
//-----------------------------------------------------------------
    String getScore(int index){
        return totalScore.get(index);
    }
//-----------------------------------------------------------------



//-----------------------------------------------------------------
    public static void main(String[] args){
        GameCard myCard = new GameCard();
        Cup myCup = new Cup();
        ArrayList<Bowler> myBowlers = new ArrayList<>(1);
        Bowler myBowler = new Bowler(0);
        for(int i = 0; i < 10; i++){
            myBowler.setRolls(i, myCup);
        }
        myBowlers.add(myBowler);

        myCard.printScoreSheetHeader();
        myCard.displayBowler(myBowlers);
    }
}//end class
