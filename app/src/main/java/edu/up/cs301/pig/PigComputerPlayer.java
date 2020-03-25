package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState) {
            double rand = Math.random();

            if (((PigGameState) info).getPlayerID() != this.playerNum){
                return;
            } else{
                if (rand <= 0.5) {
                    PigHoldAction hold = new PigHoldAction(this);
                    game.sendAction(hold);
                } else {
                    PigRollAction roll = new PigRollAction(this);
                    game.sendAction(roll);
                }
            }
        } else {
            return;
        }
    }//receiveInfo

}
