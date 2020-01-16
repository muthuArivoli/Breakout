package breakout;

import javafx.scene.Group;

public class PowerupBlock extends SpecialBlock{
    public static final String POWER_BRICK_FILE = "brick2.gif";

    private Powerup myPowerup;
    public PowerupBlock(Block myBlock,Powerup myPowerup){
        super(myBlock);
        this.myPowerup = myPowerup;
    }
    public void destroy(Group root){
        super.destroy(root);
        myPowerup.startMoving(root);
    }

}
