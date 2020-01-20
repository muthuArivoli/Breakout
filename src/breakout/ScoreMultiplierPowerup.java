package breakout;

/**
 * This represents a powerup that will multiply any points that are gained by 2 for a short period of time after
 * activation. Depends on ScoreMultiplier and Powerup.
 * @author Muthu Arivoli
 */
public class ScoreMultiplierPowerup extends Powerup {
    public static final String SCORE_MULTIPLIER_FILE = "pointspower.gif";

    private ScoreMultiplier myScoreMultiplier;

    /**
     * Creates the powerup that will modify the score multiplier
     * @param xpos x coordinate of the location of the powerup
     * @param ypos y coordinate of the location of the powerup
     * @param width the diameter of the image of the powerup
     * @param myScoreMultiplier the scoremutiplier that the powerup will be affecting
     */
    public ScoreMultiplierPowerup(int xpos, int ypos, int width, ScoreMultiplier myScoreMultiplier){
        super(SCORE_MULTIPLIER_FILE,xpos,ypos,width);
        this.myScoreMultiplier = myScoreMultiplier;
    }

    @Override
    /**
     * Activates the powerup by multiplying the score muliplier by 2, thus doubling any points gained and sets the time
     * to expire.
     */
    public void activatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue() * 2);
        setTimeToExpire(POWERUP_TIME);
    }

    @Override
    /**
     * Deactivates the powerup by dividing the score mulitplier by 2, thus returning the score multiplier back to its
     * original state before the powerup was activated.
     */
    public void deactivatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue()/2);
    }
}
