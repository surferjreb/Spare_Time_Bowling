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
                int checkValue = Integer.parseInt(args[0]);

                if(checkValue >= 1 && checkValue <= 99) {
                    setBowlerIndex(args[0]);
                    return checkBowlerNumber(bowlerIndex);
                }
            }//end if

        }
        catch (Exception e){
            displayUsage();
        }//end try/catch

        return false;
    }//end checkAmount
//--------------------------------------------------------
    private void setBowlerIndex(String bowlers){
        this.bowlerIndex = Integer.parseInt(bowlers);
    }//end setBowlerIndex
//--------------------------------------------------------
    int getBowlerIndex(){
        return bowlerIndex;
    }
//--------------------------------------------------------
    private boolean checkBowlerNumber(int bowlerCount) throws NumberFormatException{

        if (bowlerCount > 0 && bowlerCount <= MAXBOWLERS) {
            return true;

        }//end if

        throw new NumberFormatException();

    }
//--------------------------------------------------------
    public void displayUsage(){
        System.out.println();
        System.out.println("Usage: java SpareTimeDriver <#OfBowlers>");
        System.out.println();
        System.out.print("\t<#OfBowlers>    : The number of bowlers you want in the game.\n"+
            "\t\t\t\t The amount of bowlers you can have is 1 - 99\n");
        System.out.println();

    }
//--------------------------------------------------------
    public static void main(String[] args){

    }
}//end class
