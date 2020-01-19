package breakout;

import javafx.scene.Group;

/**
 * This represents a ball in the game that the player will try to manipulate to break blocks.
 */
public class Ball {
    public static final double START_X_VELOCITY = 0;
    public static final double START_Y_VELOCITY = -300;
    public static final String BALL_FILE = "ball.gif";

    private double xVelocity;
    private double yVelocity;
    private DisplayImage myBallImage;
    private boolean coupled;
    private boolean inPlay;
    public Ball(){
        myBallImage = new DisplayImage(BALL_FILE);
        inPlay = false;
    }
    public void initialize(Group root) {
        myBallImage.addImage(root);
        inPlay = true;
        resetLocation();
    }
    public double getxVelocity() {
        return xVelocity;
    }
    public double getyVelocity() {
        return yVelocity;
    }
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
    public void resetLocation(){
        myBallImage.setX(Game.LENGTH / 2.0+Paddle.PADDLE_WIDTH / 2.0-10);
        myBallImage.setY(Paddle.PADDLE_HEIGHT-20);
        xVelocity = Paddle.PADDLE_SPEED;
        coupled = true;
    }
    public void updateLocation(double elapsedTime){
        if(!coupled) {
            if (!myBallImage.inXBounds()) {
                xVelocity *= -1;
            }
            myBallImage.setX(myBallImage.getX() + this.xVelocity * elapsedTime);
            if (!myBallImage.inYBounds()) {
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
            if(!myBallImage.inXBounds()) {
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
            if(!myBallImage.inXBounds()) {
                moveCoupledLeft();
            }
        }
    }
    public DisplayImage getMyBallImage() {
        return this.myBallImage;
    }
    public boolean isInPlay() {
        return inPlay;
    }
    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }
}
