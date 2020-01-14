package breakout;

import javafx.scene.image.ImageView;

public class BallSpeedPowerup extends Powerup{
    public static final double BALL_SPEED_FACTOR = 2.0;

    private Ball myBall;
    public BallSpeedPowerup(ImageView myPowerUpImage, Ball myBall){
        super(myPowerUpImage);
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
