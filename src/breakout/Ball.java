package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This represents a ball in the game that the player will try to manipulate to break blocks.
 */
public class Ball {
    public static final double START_X_VELOCITY=250;
    public static final double START_Y_VELOCITY=-300;
    public static final String BALL_FILE = "ball.gif";

    private double xVelocity;
    private double yVelocity;
    private ImageView myBallImage;
    private boolean coupled;

    public Ball(Group root){
        myBallImage = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(BALL_FILE)));
        root.getChildren().add(myBallImage);
        resetLocation();
    }
    public double getxVelocity() {
        return xVelocity;
    }
    public double getyVelocity() {
        return yVelocity;
    }
    public double getX(){
        return myBallImage.getX();
    }
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
    public void resetLocation(){
        myBallImage.setX(Game.LENGTH /2+Paddle.PADDLE_WIDTH/2-10);
        myBallImage.setY(Paddle.PADDLE_HEIGHT-20);
        xVelocity = Paddle.PADDLE_SPEED;
        coupled = true;
    }
    public void updateLocation(double elapsedTime){
        if(!coupled) {
            if (!inXBounds()) {
                xVelocity *= -1;
            }
            myBallImage.setX(myBallImage.getX() + this.xVelocity * elapsedTime);
            if (!inYBounds()) {
                yVelocity *= -1;
            }
            myBallImage.setY(myBallImage.getY() + this.yVelocity * elapsedTime);
        }
    }

    /**
     * Remove coupling with paddle, and let it start moving on its own
     */
    public void uncouple(){
        if(coupled) {
            coupled = false;
            xVelocity = START_X_VELOCITY;
            yVelocity = START_Y_VELOCITY;
        }
    }

    /**
     * Move left when initially attached to the paddle.
     */
    public void moveCoupledLeft(){
        if(coupled){
            myBallImage.setX(myBallImage.getX() - Paddle.PADDLE_SPEED);
            if(!inXBounds()) {
                moveCoupledRight();
            }
        }
    }

    /**
     * Move right when initially attached to paddle.
     */
    public void moveCoupledRight(){
        if(coupled){
            myBallImage.setX(myBallImage.getX() + Paddle.PADDLE_SPEED);
            if(!inXBounds()) {
                moveCoupledLeft();
            }
        }
    }
    public boolean atBottom(){
        return (myBallImage.getBoundsInParent().getMinY()>Paddle.PADDLE_HEIGHT);
    }
    public boolean inXBounds(){
        return (myBallImage.getBoundsInParent().getMinX()>0 && myBallImage.getBoundsInParent().getMaxX()<Game.LENGTH);
    }
    public boolean inYBounds(){
        return (myBallImage.getBoundsInParent().getMinY()>0 && myBallImage.getBoundsInParent().getMaxY()<Game.LENGTH);
    }
    public Bounds getBounds(){
        return myBallImage.getBoundsInParent();
    }
}
