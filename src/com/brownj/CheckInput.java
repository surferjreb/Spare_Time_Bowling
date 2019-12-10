package com.brownj;

public class CheckInput {
    private final int MAXBOWLERS = 99;
    private int bowlerIndex;
    CheckInput(){
        this.bowlerIndex = 0;
    }

    //-------------------------------------------------------
    boolean checkAmount(String[] args){

        try {

            if(args.length > 0) {
                setBowlerIndex(args[0]);
                return checkBowlerNumber(bowlerIndex);
            }//end if

        }
        catch (Exception e){
            e.printStackTrace();
        }//end try/catch

        return false;
    }//end checkAmount
//--------------------------------------------------------
    private void setBowlerIndex(String bowlers){
        this.bowlerIndex = Integer.parseInt(bowlers);
    }//end setBowlerIndex
//--------------------------------------------------------
    private boolean checkBowlerNumber(int bowlerCount) throws NumberFormatException{

        if (bowlerCount > 0 && bowlerCount <= MAXBOWLERS) {
            return true;

        }//end if

        throw new NumberFormatException();

    }
}
