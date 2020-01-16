package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class PaddleSpeedPowerup extends Powerup{
    public static final String BALL_SPEED_FILE = "laserpower.gif";
    public static final double SPEED_FACTOR = 1.6;

    private Paddle myPaddle;
    public PaddleSpeedPowerup(int xpos, int ypos, int width, Group root, Paddle myPaddle){
        super(BALL_SPEED_FILE, xpos, ypos, width, root);
        this.myPaddle = myPaddle;
    }
    @Override
    public void activatePowerup() {
        myPaddle.setSpeed(SPEED_FACTOR*myPaddle.getSpeed());
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myPaddle.setSpeed(myPaddle.getSpeed()/SPEED_FACTOR);
    }
}
