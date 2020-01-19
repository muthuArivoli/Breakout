package breakout;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class Pinball {
    public static final int PINBALL_SPEED = 15;
    public static final int PINBALL_WIDTH = 40;
    public static final int PINBALL_HEIGHT = 10;
    public static final String LEFT_PINBALL_FILE = "paddle.gif";
    public static final String RIGHT_PINBALL_FILE = "paddle.gif";

    private DisplayImage myLeftPinballImage = new DisplayImage(LEFT_PINBALL_FILE);
    private DisplayImage myRightPinballImage = new DisplayImage(RIGHT_PINBALL_FILE);
    private Rotate leftRotation;
    private Rotate rightRotation;
    private double speed;
    public Pinball(Group root){
        initialize(myLeftPinballImage,root,0,Game.WIDTH-150);
        initialize(myRightPinballImage,root, Game.LENGTH - PINBALL_WIDTH,Game.WIDTH-150);
        speed = PINBALL_SPEED;
        leftRotation = new Rotate();
        leftRotation.setPivotX(0);//Set the Pivot's X to be the same location as the Circle's X.
        leftRotation.setPivotY(Game.LENGTH - 150);//Set the Pivot's Y to be the same location as the Circle's Y
        myLeftPinballImage.addTransform(leftRotation);
        rightRotation = new Rotate();
        rightRotation.setPivotX(Game.LENGTH );//Set the Pivot's X to be the same location as the Circle's X.
        rightRotation.setPivotY(Game.LENGTH - 150);//Set the Pivot's Y to be the same location as the Circle's Y.
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
    public void moveUp(){
        leftRotation.setAngle(Math.max(-90,leftRotation.getAngle() - speed));
        rightRotation.setAngle(Math.min(90,rightRotation.getAngle() + speed));
    }
    public void moveDown(){
        leftRotation.setAngle(Math.min(75,leftRotation.getAngle() + speed));
        rightRotation.setAngle(Math.max(-75,rightRotation.getAngle() - speed));
    }
    public DisplayImage getMyLeftPinballImage() {
        return myLeftPinballImage;
    }
    public DisplayImage getMyRightPinballImage(){
        return myRightPinballImage;
    }
    public void resetLocation(){
        myLeftPinballImage.setRotate(0);
        myRightPinballImage.setRotate(0);
    }
    public double getRightAngle(){
        return rightRotation.getAngle();
    }
    public double getLeftAngle(){
        return leftRotation.getAngle();
    }
}
