package breakout;

/**
 * This represents a powerup that increases the paddle speed for a short amount of time.
 * Depends on Powerup and Paddle
 * @author Muthu Arivoli
 */
public class PaddleSpeedPowerup extends Powerup{
    public static final String BALL_SPEED_FILE = "laserpower.gif";
    public static final double SPEED_FACTOR = 2.0;

    private Paddle myPaddle;

    /**
     * Creates the new powerup that modifies the paddle speed
     * @param xpos x coordinate of the location of the powerup
     * @param ypos y coordinate of the location of the powerup
     * @param width the diameter of the image of the powerup
     * @param myPaddle the paddle that the powerup will be affecting
     */
    public PaddleSpeedPowerup(int xpos, int ypos, int width, Paddle myPaddle){
        super(BALL_SPEED_FILE, xpos, ypos, width);
        this.myPaddle = myPaddle;
    }

    /**
     * Activates the powerup by speeding up the movement of the paddle by SPEED_FACTOR and sets the time to expire.
     */
    @Override
    public void activatePowerup() {
        myPaddle.setSpeed(SPEED_FACTOR*myPaddle.getSpeed());
        setTimeToExpire(POWERUP_TIME);
    }

    @Override
    public void deactivatePowerup() {
        myPaddle.setSpeed(myPaddle.getSpeed()/SPEED_FACTOR);
    }
}
