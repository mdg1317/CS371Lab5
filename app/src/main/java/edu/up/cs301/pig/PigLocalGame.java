package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        int currentTurn = state.getPlayerID();
        if(currentTurn == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        int currentPlayer = state.getPlayerID();
        int currTotal = state.getRunningTotal();
        int rand;

        if(action instanceof PigHoldAction){
            if(currentPlayer == 0) {
                state.setScore0(state.getScore0() + currTotal);
                state.setPlayerID(1);
            } else if(currentPlayer == 1){
                state.setScore1(state.getScore1() + currTotal);
                state.setPlayerID(0);
            }
            state.setRunningTotal(0);
            return true;
        } else if(action instanceof PigRollAction){
            rand = (int)(Math.random() * 6) + 1;
            state.setDiceValue(rand);
            if(rand != 1){
                state.setRunningTotal(currTotal + rand);
            } else {
                if(currentPlayer == 0){
                    state.setPlayerID(1);
                } else {
                    state.setPlayerID(0);
                }
                state.setRunningTotal(0);
            }
            return true;
        }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copy = new PigGameState(state);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        int score0 = state.getScore0();
        int score1 = state.getScore1();
        String winner;

        if(score0 >= 50){
            winner = this.playerNames[0];
            return winner + " wins with a score of " + score0 + "! ";
        } else if(score1 >= 50){
            winner = this.playerNames[1];
            return winner + " wins with a score of " + score1 + "! ";
        } else {
            return null;
        }
    }

}// class PigLocalGame
