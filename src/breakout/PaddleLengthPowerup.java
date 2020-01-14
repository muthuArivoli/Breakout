package breakout;

import javafx.scene.image.ImageView;

public class PaddleLengthPowerup extends Powerup{
    public static final double STRETCH_FACTOR = 1.4;

    private Paddle myPaddle;
    public PaddleLengthPowerup(Paddle myPaddle,ImageView myPowerUpImage){
        super(myPowerUpImage);
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
