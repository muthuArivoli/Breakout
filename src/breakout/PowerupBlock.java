package breakout;

import javafx.scene.Group;

public class PowerupBlock extends SpecialBlock{
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
