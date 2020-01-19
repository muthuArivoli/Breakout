package breakout;

import javafx.scene.Group;

/**
 * This represents a brick that releases a ball once the brick is broken
 * @author Muthu Arivoli
 */
public class MultipleBallBrick extends SpecialBrick {
    public static final String MULTIPLE_BRICK_FILE = "brick5.gif";

    private Ball mySecondaryBall;

    /**
     * Creates a brick that will release a ball once broken.
     * @param myBrick Brick that will now release a ball once broken
     * @param mySecondaryBall the ball that will be released once broken
     */
    public MultipleBallBrick(Brick myBrick, Ball mySecondaryBall){
        super(myBrick);
        this.mySecondaryBall = mySecondaryBall;
    }

    @Override
    /**
     * Removes the brick from the display and adds the ball that is being released to the display and releases it.
     */
    public void destroy(Group root) {
        mySecondaryBall.setInPlay(true);
        mySecondaryBall.getMyBallImage().setX(this.getMyBrickImage().getX());
        mySecondaryBall.getMyBallImage().setY(this.getMyBrickImage().getY());
        mySecondaryBall.setxVelocity(Ball.START_X_VELOCITY);
        mySecondaryBall.setyVelocity(Ball.START_Y_VELOCITY);
        super.destroy(root);
        mySecondaryBall.getMyBallImage().addImage(root);
    }
}
