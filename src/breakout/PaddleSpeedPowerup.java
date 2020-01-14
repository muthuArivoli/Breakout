package breakout;

import javafx.scene.image.ImageView;

public class PaddleSpeedPowerup extends Powerup{
    public static final double SPEED_FACTOR = 1.6;
    private Paddle myPaddle;
    public PaddleSpeedPowerup(Paddle myPaddle,ImageView myPowerUpImage){
        super(myPowerUpImage);
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
