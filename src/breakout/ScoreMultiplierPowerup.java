package breakout;

import javafx.scene.Group;


/**
 * This represents a powerup that will multiply any points that are gained by 2 for a short period of time after
 * activation
 */
public class ScoreMultiplierPowerup extends Powerup {
    public static final String SCORE_MULTIPLIER_FILE = "pointspower.gif";
    private ScoreMultiplier myScoreMultiplier;
    public ScoreMultiplierPowerup(int xpos, int ypos, int width, Group root, ScoreMultiplier myScoreMultiplier){
        super(SCORE_MULTIPLIER_FILE,xpos,ypos,width);
        this.myScoreMultiplier = myScoreMultiplier;
    }
    @Override
    public void activatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue()*2);
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue()/2);
    }
}
