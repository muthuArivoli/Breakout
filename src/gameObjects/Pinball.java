package gameObjects;

import breakout.Game;
import displayImage.DisplayImage;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

/**
 * A pinball striker that is placed on the side of the screen as another tool to hit the ball.
 * Depends on DisplayImage
 * @author Muthu Arivoli
 */
public class Pinball {
    public static final int PINBALL_SPEED = 15;
    public static final int PINBALL_WIDTH = 40;
    public static final int PINBALL_HEIGHT = 10;
    public static final double PINBALL_START_Y_POSITION = Game.WIDTH-150;
    public static final double LEFT_PINBALL_START_X_POSITION = 0;
    public static final double RIGHT_PINBALL_START_X_POSITION = Game.LENGTH - PINBALL_WIDTH;
    public static final String LEFT_PINBALL_FILE = "paddle.gif";
    public static final String RIGHT_PINBALL_FILE = "paddle.gif";
    public static final int LEFT_PINBALL_MAX_FINAL_UP_ANGLE = -90;
    public static final int RIGHT_PINBALL_MAX_FINAL_UP_ANGLE = 90;
    public static final int LEFT_PINBALL_MAX_FINAL_DOWN_ANGLE = 75;
    public static final int RIGHT_PINBALL_MAX_FINAL_DOWN_ANGLE = -75;
    public static final double PINBALL_Y_PIVOT_POSITION = Game.LENGTH - 150;

    private DisplayImage myLeftPinballImage = new DisplayImage(LEFT_PINBALL_FILE);
    private DisplayImage myRightPinballImage = new DisplayImage(RIGHT_PINBALL_FILE);
    private Rotate leftRotation;
    private Rotate rightRotation;
    private double speed;

    /**
     * Create the new pinball mechanism and define the pivot points for rotation and display it on the screen.
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    public Pinball(Group root){
        initialize(myLeftPinballImage,root,LEFT_PINBALL_START_X_POSITION,PINBALL_START_Y_POSITION);
        initialize(myRightPinballImage,root, RIGHT_PINBALL_START_X_POSITION,PINBALL_START_Y_POSITION);
        speed = PINBALL_SPEED;
        leftRotation = new Rotate();
        leftRotation.setPivotX(LEFT_PINBALL_START_X_POSITION);
        leftRotation.setPivotY(PINBALL_Y_PIVOT_POSITION);
        myLeftPinballImage.addTransform(leftRotation);
        rightRotation = new Rotate();
        rightRotation.setPivotX(Game.LENGTH);
        rightRotation.setPivotY(PINBALL_Y_PIVOT_POSITION);
        myRightPinballImage.addTransform(rightRotation);
        resetLocation();
    }

    private void initialize(DisplayImage myPinballImage, Group root, double x, double y){
        myPinballImage.setFitWidth(PINBALL_WIDTH);
        myPinballImage.setFitHeight(PINBALL_HEIGHT);
        myPinballImage.addImage(root);
        myPinballImage.setX(x);
        myPinballImage.setY(y);
    }

    /**
     * Moves the pinball strikers upward simultaneously
     */
    public void moveUp(){
        leftRotation.setAngle(Math.max(LEFT_PINBALL_MAX_FINAL_UP_ANGLE,leftRotation.getAngle() - speed));
        rightRotation.setAngle(Math.min(RIGHT_PINBALL_MAX_FINAL_UP_ANGLE,rightRotation.getAngle() + speed));
    }

    /**
     * Moves the pinball strikers downward simultaneously
     */
    public void moveDown(){
        leftRotation.setAngle(Math.min(LEFT_PINBALL_MAX_FINAL_DOWN_ANGLE,leftRotation.getAngle() + speed));
        rightRotation.setAngle(Math.max(RIGHT_PINBALL_MAX_FINAL_DOWN_ANGLE,rightRotation.getAngle() - speed));
    }

    /**
     * Gets the image of the pinball striker on the left of the display
     * @return the image of the left pinball striker being displayed
     */
    public DisplayImage getMyLeftPinballImage() {
        return myLeftPinballImage;
    }

    /**
     * Gets the image of the pinball striker on the right of the display
     * @return the image of the right pinball striker being displayed
     */
    public DisplayImage getMyRightPinballImage(){
        return myRightPinballImage;
    }

    /**
     * Resets the position of the pinball striker to its original rotation
     */
    public void resetLocation(){
        myLeftPinballImage.setRotate(0);
        myRightPinballImage.setRotate(0);
    }

    /**
     * Gets the angle of the pinball striker on the right
     * @return the angle of the right pinball striker
     */
    public double getRightAngle(){
        return rightRotation.getAngle();
    }

    /**
     * Gets the angle of the pinball striker on the left
     * @return the angle of the left pinball striker
     */
    public double getLeftAngle(){
        return leftRotation.getAngle();
    }
}
