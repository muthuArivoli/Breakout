package breakout;

import javafx.scene.Group;

/**
 * This represents a powerup that increases the length of the paddle for a short amount of time.
 */
public class PaddleLengthPowerup extends Powerup{
    public static final double STRETCH_FACTOR = 1.4;
    public static final String PADDLE_LENGTH_FILE = "sizepower.gif";
    private Paddle myPaddle;
    public PaddleLengthPowerup(int xpos, int ypos, int width, Group root,Paddle myPaddle){
        super(PADDLE_LENGTH_FILE,xpos,ypos,width);
        this.myPaddle = myPaddle;
    }
    @Override
    public void activatePowerup() {
        myPaddle.stretch(STRETCH_FACTOR);
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myPaddle.stretch(1/STRETCH_FACTOR);
    }
}
