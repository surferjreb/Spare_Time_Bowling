package com.brownj;

public class SpareTimeDriver {

    public static void main(String[] args) {
        args = new String[2];

        Controller myControl = new Controller();
        CheckInput myCheck = new CheckInput();
        //test program
        args[0]= "2";

        try {
            if (myCheck.checkAmount(args)) {
                myControl.runController(args);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
