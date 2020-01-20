package breakout;

import javafx.scene.Group;

/**
 * This represents a ball in the game that the player will try to manipulate to break blocks. Depends on DisplayImage.
 * @author Muthu Arivoli
 */
public class Ball {
    public static final double START_X_VELOCITY = 250;
    public static final double START_Y_VELOCITY = -300;
    public static final String BALL_FILE = "ball.gif";

    private double xVelocity;
    private double yVelocity;
    private DisplayImage myBallImage;
    private boolean isCoupledWithPaddle;
    private boolean inPlay;

    /**
     * Creates the ball, but does not put it in play immediately
     */
    public Ball(){
        myBallImage = new DisplayImage(BALL_FILE);
        inPlay = false;
    }

    /**
     * Initializes the ball and displays its
     * @param root the group that contains all of the objects currently being displayed
     */
    public void initialize(Group root) {
        myBallImage.addImage(root);
        inPlay = true;
        resetLocation();
    }

    /**
     * Gets the x velocity component of the balls velocity
     * @return the x velocity of the ball
     */
    public double getxVelocity() {
        return xVelocity;
    }

    /**
     * Gets the y velocity component of the balls velocity
     * @return the y velocity of the ball
     */
    public double getyVelocity() {
        return yVelocity;
    }

    /**
     * Sets the x veloctiy component of the ball
     * @param xVelocity the new x velocity component of the ball
     */
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    /**
     * Sets the y veloctiy component of the ball
     * @param yVelocity the new y velocity component of the ball
     */
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    /**
     * Resets the location of the ball to be right above the paddle in the center of the screen, like at the start of the game
     */
    public void resetLocation(){
        myBallImage.setX(Game.LENGTH / 2.0+Paddle.PADDLE_WIDTH / 2.0-10);
        myBallImage.setY(Paddle.PADDLE_HEIGHT-20);
        xVelocity = Paddle.PADDLE_SPEED;
        isCoupledWithPaddle = true;
    }

    /**
     * Update the location of the ball based on the current location and velocity of the ball. Also prevents ball from
     * going out of bounds of the box
     * @param elapsedTime the amount of time that has elapsed since last frame
     */
    public void updateLocation(double elapsedTime){
        if(!isCoupledWithPaddle) {
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
        if(isCoupledWithPaddle) {
            isCoupledWithPaddle = false;
            xVelocity = START_X_VELOCITY;
            yVelocity = START_Y_VELOCITY;
        }
    }

    /**
     * Move the ball left when initially attached to the paddle.
     */
    public void moveCoupledLeft(){
        if(isCoupledWithPaddle){
            myBallImage.setX(myBallImage.getX() - Paddle.PADDLE_SPEED);
            if(!myBallImage.inXBounds()) {
                moveCoupledRight();
            }
        }
    }

    /**
     * Move the ball right when initially attached to paddle.
     */
    public void moveCoupledRight(){
        if(isCoupledWithPaddle){
            myBallImage.setX(myBallImage.getX() + Paddle.PADDLE_SPEED);
            if(!myBallImage.inXBounds()) {
                moveCoupledLeft();
            }
        }
    }

    /**
     * Gets the image of the ball on the display
     * @return the image of the ball being displayed
     */
    public DisplayImage getMyBallImage() {
        return this.myBallImage;
    }

    /**
     * Gets whether the ball is in play, or is out of play by being hidden inside a block
     * @return whether the ball is currently in play and is actively being used to break bricks
     */
    public boolean isInPlay() {
        return inPlay;
    }

    /**
     * Sets whether the ball is in play or out of play
     * @param inPlay the new value of whether the ball is in play or out of play
     */
    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }
}
