package brick;

import javafx.scene.Group;
import powerup.Powerup;

/**
 * This represents a special brick that contains a powerup that is hidden inside and released once the brick is broken.
 * Depends on SpecialBrick
 * @author Muthu Arivoli
 */
public class PowerupBrick extends SpecialBrick {
    public static final String POWER_BRICK_FILE = "brick4.gif";

    private Powerup myPowerup;

    /**
     * Creates the new brick that will release the powerup once broken
     * @param myBrick the brick that will now drop a powerup once broken
     * @param myPowerup the powerup that will be released once the brick is broken
     */
    public PowerupBrick(Brick myBrick, Powerup myPowerup){
        super(myBrick);
        this.myPowerup = myPowerup;
    }

    /**
     * Removes the brick from the display and starts dropping the powerup
     */
    @Override
    public void destroy(Group root){
        super.destroy(root);
        myPowerup.startMoving(root);
    }

}
