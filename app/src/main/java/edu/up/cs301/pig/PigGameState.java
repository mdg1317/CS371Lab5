package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    //instance variables
    private int playerID;
    private int score0;
    private int score1;
    private int runningTotal;
    private int diceValue;

    //default constructor
    public PigGameState(){
        playerID = 0;
        score0 = 0;
        score1 = 0;
        runningTotal = 0;
        diceValue = 0;
    }

    //copy constructor
    public PigGameState(PigGameState orig){
        playerID = orig.getPlayerID();
        score0 = orig.getScore(0);
        score1 = orig.getScore(1);
        runningTotal = orig.getRunningTotal();
        diceValue = orig.getDiceValue();
    }

    public int getPlayerID(){
        return playerID;
    }

    public void setPlayerID(int id){
        playerID = id;
    }

    public int getScore(int id){
        if(id == 0) {
            return score0;
        } else if(id == 1){
            return score1;
        } else {
            return -1;
        }
    }

    public void setScore(int id, int score){
        if(id == 0) {
            score0 = score;
        } else if(id == 1){
            score1 = score;
        }
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public void setRunningTotal(int total){
        runningTotal = total;
    }

    public int getDiceValue(){
        return diceValue;
    }

    public void setDiceValue(int value){
        diceValue = value;
    }
}