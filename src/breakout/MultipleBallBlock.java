package breakout;

import javafx.scene.Group;

public class MultipleBallBlock extends SpecialBlock {
    public static final String MULTIPLE_BRICK_FILE = "brick5.gif";

    private Ball mySecondaryBall;
    public MultipleBallBlock(Block myBlock,Ball mySecondaryBall){
        super(myBlock);
        this.mySecondaryBall = mySecondaryBall;
    }

    @Override
    public void destroy(Group root) {
        mySecondaryBall.setInPlay(true);
        mySecondaryBall.setX(getX());
        mySecondaryBall.setY(getY());
        mySecondaryBall.setxVelocity(Ball.START_X_VELOCITY);
        mySecondaryBall.setyVelocity(Ball.START_Y_VELOCITY);
        super.destroy(root);
        root.getChildren().add(mySecondaryBall.getMyBallImage());
    }
}
