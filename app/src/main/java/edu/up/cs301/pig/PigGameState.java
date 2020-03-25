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
        score0 = orig.getScore0();
        score1 = orig.getScore1();
        runningTotal = orig.getRunningTotal();
        diceValue = orig.getDiceValue();
    }

    public int getPlayerID(){
        return playerID;
    }

    public void setPlayerID(int id){
        playerID = id;
    }

    public int getScore0(){
        return score0;
    }

    public void setScore0(int score){
        score0 = score;
    }

    public int getScore1(){
        return score1;
    }

    public void setScore1(int score){
        score1 = score;
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