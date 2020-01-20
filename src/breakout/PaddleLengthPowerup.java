package breakout;

/**
 * This represents a powerup that increases the length of the paddle for a short amount of time.
 * Depends on Paddle and Powerup.
 * @author Muthu Arivoli
 */
public class PaddleLengthPowerup extends Powerup{
    public static final double STRETCH_FACTOR = 1.4;
    public static final String PADDLE_LENGTH_FILE = "sizepower.gif";

    private Paddle myPaddle;

    /**
     * Creates the new powerup that modifies the paddle length
     * @param xpos x coordinate of the location of the powerup
     * @param ypos y coordinate of the location of the powerup
     * @param width the diameter of the image of the powerup
     * @param myPaddle the paddle that the powerup will be affecting
     */
    public PaddleLengthPowerup(int xpos, int ypos, int width,Paddle myPaddle){
        super(PADDLE_LENGTH_FILE,xpos,ypos,width);
        this.myPaddle = myPaddle;
    }

    /**
     * Activate the powerup by increasing the length of the paddle by STRETCH_FACTOR and sets the time to expire.
     */
    @Override
    public void activatePowerup() {
        myPaddle.stretch(STRETCH_FACTOR);
        setTimeToExpire(POWERUP_TIME);
    }

    /**
     * Deactivates the powerup by reducing the length of the paddle by SIZE_FACTOR, this returning the paddle to its
     * length before the powerup was activated.
     */
    @Override
    public void deactivatePowerup() {
        myPaddle.stretch(1/STRETCH_FACTOR);
    }
}
