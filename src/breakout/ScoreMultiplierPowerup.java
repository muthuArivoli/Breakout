package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ScoreMultiplierPowerup extends Powerup {
    public static final String SCORE_MULTIPLIER_FILE = "pointspower.gif";
    private ScoreMultiplier myScoreMultiplier;
    public ScoreMultiplierPowerup(int xpos, int ypos, int width, Group root, ScoreMultiplier myScoreMultiplier){
        super(SCORE_MULTIPLIER_FILE,xpos,ypos,width,root);
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
