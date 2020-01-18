package breakout;

import javafx.scene.Group;

public class MultipleBallBrick extends SpecialBrick {
    public static final String MULTIPLE_BRICK_FILE = "brick5.gif";

    private Ball mySecondaryBall;
    public MultipleBallBrick(Brick myBrick, Ball mySecondaryBall){
        super(myBrick);
        this.mySecondaryBall = mySecondaryBall;
    }

    @Override
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
