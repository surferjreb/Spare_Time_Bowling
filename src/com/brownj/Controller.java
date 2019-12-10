package com.brownj;

import java.util.ArrayList;

public class Controller {
    private GameManager myGame;
    private GameCard myCard;
    Controller(){
        myGame = new GameManager();
        myCard = new GameCard();

    }

    void runController(String[] bowlerAmount){
        String bowlers = bowlerAmount[0];

        myGame.InitiateGame(bowlers, myCard);
       // myCard.displayGameCard();

    }

}
