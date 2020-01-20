package breakout;

/**
 * This represents a powerup that temporarily slows down the main (initial) ball for a short amount of time. Depends on
 * Ball and Powerup
 * @author Muthu Arivoli
 */
public class BallSpeedPowerup extends Powerup{
    public static final double BALL_SPEED_FACTOR = 2.0;
    public static final String BALL_SPEED_FILE = "extraballpower.gif";

    private Ball myBall;

    /**
     * Creates the new ball speed powerup
     * @param xpos x coordinate of the location of the powerup
     * @param ypos y coordinate of the location of the powerup
     * @param width the diameter of the image of the powerup
     * @param myBall the ball that the powerup will be affecting
     */
    public BallSpeedPowerup(int xpos, int ypos, int width, Ball myBall){
        super(BALL_SPEED_FILE,xpos,ypos,width);
        this.myBall = myBall;
    }

    @Override
    /**
     * Activate the powerup by slowing the ball down by BALL_SPEED_FACTOR and sets the time to expire.
     */
    public void activatePowerup() {
        myBall.setxVelocity(myBall.getxVelocity()/BALL_SPEED_FACTOR);
        myBall.setyVelocity(myBall.getyVelocity()/BALL_SPEED_FACTOR);
        setTimeToExpire(POWERUP_TIME);
    }

    @Override
    /**
     * Deactivates the powerup by speeding the ball up by BALL_SPEED_FACTOR, thus returning it back to its original speed
     * before the powerup was activated
     */
    public void deactivatePowerup() {
        myBall.setxVelocity(myBall.getxVelocity()*BALL_SPEED_FACTOR);
        myBall.setyVelocity(myBall.getyVelocity()*BALL_SPEED_FACTOR);
    }
}
