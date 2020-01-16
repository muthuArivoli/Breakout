package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class BallSpeedPowerup extends Powerup{
    public static final double BALL_SPEED_FACTOR = 2.0;
    public static final String BALL_SPEED_FILE = "extraballpower.gif";
    private Ball myBall;
    public BallSpeedPowerup(int xpos, int ypos, int width, Group root, Ball myBall){
        super(BALL_SPEED_FILE,xpos,ypos,width,root);
        this.myBall = myBall;
    }
    @Override
    public void activatePowerup() {
        myBall.setxVelocity(BALL_SPEED_FACTOR*myBall.getxVelocity());
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myBall.setxVelocity(myBall.getxVelocity()/BALL_SPEED_FACTOR);
    }
}
