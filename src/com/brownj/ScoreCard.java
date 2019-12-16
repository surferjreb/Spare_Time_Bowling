package com.brownj;

import java.util.ArrayList;

public class ScoreCard {
    private final int MAXFRAMES = 10;
    private ArrayList<String> scores;
    private int totalScore;

    ScoreCard(){
        totalScore = 0;
        scores = new ArrayList<>(MAXFRAMES);
    }
//-----------------------------------------------------------------
    ArrayList<String> scoreCard(ArrayList<String> myScores){
        for(int i = 0; i < myScores.size(); i++){
            if(i > 0) {
                myScores.set((i-1), scores.get(i-1));

            }
            setFrameScore(myScores, i);
        }

        return getBowlerScores();
    }
//-----------------------------------------------------------------
    private void setFrameScore(ArrayList<String> score, int frameNumber){
        String frameScore;

        if(frameNumber < MAXFRAMES - 1) {
            frameScore = calculateFrameScore(score, frameNumber);
        }
        else{
            frameScore = calculateLastFrameScore(score, frameNumber);
        }

        scores.add(frameNumber, frameScore);

    }
//-----------------------------------------------------------------
    private String calculateFirstFrameScore(ArrayList<String> score, int frameNumber){
        String frame;
        String frame2;
        String frame3;
        String frameScore;
        int tempScore = 0;

        frame = score.get(frameNumber).toLowerCase();
        frame2 = score.get(frameNumber + 1).toLowerCase();
        frame3 = score.get(frameNumber + 2).toLowerCase();

        if(frame.equals("x")){
            tempScore = 10;
            tempScore = checkSecondFrame(tempScore, frame2, frame3);
        }
        else{
            if(frame.length() > 1){

                if(frame.charAt(1) == '/'){
                    tempScore = 10;
                    tempScore = checkSecondFrame(tempScore, frame2, frame3);
                                   }
                else{
                    tempScore += checkSecondFrame(tempScore, frame2, frame3);
                    tempScore += Integer.parseInt(String.valueOf(frame.charAt(0))) +
                            Integer.parseInt(String.valueOf(frame.charAt(1)));
                }

            }

        }

        frameScore = String.valueOf(tempScore);
        return frameScore;
    }
//-----------------------------------------------------------------
    private String calculateFrameScore(ArrayList<String> myScore, int frameNumber){
        String frame;
        String frame2;
        String frame3;
        String frameScore;
        int tempScore;

        frame = myScore.get(frameNumber).toLowerCase();
        frame2 = myScore.get(frameNumber + 1).toLowerCase();
        
        if(frameNumber < MAXFRAMES - 2){
            frame3 = myScore.get(frameNumber + 2).toLowerCase();
        }
        else{
            if(myScore.get(frameNumber + 1).length() > 1) {
                frame3 = String.valueOf(myScore.get(frameNumber + 1).charAt(1)).toLowerCase();
            }
            else{
                frame3 = "0";
            }
        }
        
        if(frameNumber > 0){
        tempScore = Integer.parseInt(myScore.get(frameNumber - 1));
         }
         else{
         tempScore = 0;
         }
         
        if(frame.equals("x")){
            tempScore += 10;
            tempScore = checkSecondFrame(tempScore, frame2, frame3);
        }
        else{
            if(frame.length() > 1){

                if(frame.charAt(1) == '/'){
                    tempScore += 10;
                    tempScore += Integer.parseInt(String.valueOf(frame2.charAt(0)));
                    
                }
                else{
                    tempScore += Integer.parseInt(String.valueOf(frame.charAt(0))) +
                            Integer.parseInt(String.valueOf(frame.charAt(1))); 
                }

            }
        }

        frameScore = String.valueOf(tempScore);
        return frameScore;
    }
//-----------------------------------------------------------------
    private int checkSecondFrame(int tempScore, String frame2, String frame3){
        int temp = tempScore;

        if(frame2.charAt(0) == 'x'){
            temp += 10;
            temp = checkThirdFrame(temp, frame3);
        }
        else if(frame2.length() > 1){

            if(frame2.charAt(1) == '/'){
                temp += 10;
            }
            else{
               temp += Integer.parseInt(String.valueOf(frame2.charAt(0))) +
                            Integer.parseInt(String.valueOf(frame2.charAt(1)));
            }

        }

        return temp;
    }
//-----------------------------------------------------------------
    private int checkThirdFrame(int tempScore, String frame3){
        int temp = tempScore;

        if(frame3.equals("x")){
            temp += 10;
        }
        else if(frame3.length() > 1){
            if(frame3.charAt(1) == '/') {
               
                  temp += Integer.parseInt(String.valueOf(frame3.charAt(0)));
            }
            else{
                
                temp = tempScore + Integer.parseInt(String.valueOf(frame3.charAt(0)));
            }
        }


        return temp;
    }
//-----------------------------------------------------------------
    private String calculateLastFrameScore(ArrayList<String> score, int frameNumber){
        char[] shot;
        int totalScore = Integer.parseInt(scores.get(frameNumber - 1));

        shot = score.get(frameNumber).toLowerCase().toCharArray();

        for(int i = 0; i < shot.length; i++){
            switch (shot[i]){
                case 'x':
                            totalScore += 10;
                            break;
                case '/':
                            totalScore += 10;
                            break;

            }
            
            if(shot.length == 3 && i > 1){
               totalScore += Integer.parseInt(String.valueOf(shot[i]));
            }
            else if(shot.length == 2 && shot[1] != '/'){
                totalScore += Integer.parseInt(String.valueOf(shot[i]));
            }
            
        }

        
        return String.valueOf(totalScore);
    }
//-----------------------------------------------------------------
    private ArrayList<String> getBowlerScores(){
        return scores;
    }
//-----------------------------------------------------------------
    public static void main(String[] args){
        ScoreCard myScore = new ScoreCard();
        ArrayList<String> totalScores;
        ArrayList<String> shots;

        totalScores = new ArrayList<>(10);
        shots = new ArrayList<>(10);

        shots.add("X");
        shots.add("54");
        shots.add("9/");
        shots.add("45");
        shots.add("X");
        shots.add("5/");
        shots.add("8/");
        shots.add("51");
        shots.add("X");
        shots.add("X");

        totalScores = myScore.scoreCard(shots);

        for(int i = 0; i < 10; i++){
            System.out.println(i+": "+ totalScores.get(i));
        }
    }
}
