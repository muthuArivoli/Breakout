package breakout;

import javafx.scene.image.ImageView;

public class ScoreMultiplierPowerup extends Powerup {

    private ScoreMultiplier myScoreMultiplier;
    public ScoreMultiplierPowerup(ScoreMultiplier myScoreMultiplier, ImageView myPowerUpImage){
        super(myPowerUpImage);
        this.myScoreMultiplier = myScoreMultiplier;
    }
    @Override
    public void activatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue()*2);
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myScoreMultiplier.setValue(myScoreMultiplier.getValue()/2);
    }
}
