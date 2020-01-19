package breakout;

import javafx.scene.Group;

/**
 * This represents the paddle that the player will control to prevent the ball from going out of bounds.
 * @author Muthu Arivoli
 */
public class Paddle {
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WIDTH = 80;
    public static final int PADDLE_HEIGHT = Game.LENGTH -40;
    public static final String PADDLE_FILE = "paddle.gif";

    private DisplayImage myPaddleImage = new DisplayImage(PADDLE_FILE);
    private double speed;

    /**
     * Creates the new Paddle and adds it to the display
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    public Paddle(Group root){
        myPaddleImage.setFitWidth(PADDLE_WIDTH);
        myPaddleImage.addImage(root);
        speed = PADDLE_SPEED;
        resetLocation();
    }

    /**
     * Stretch the paddle to make it longer by a certain factor
     * @param factor the factor by which to stretch the paddle
     */
    public void stretch(double factor){
        myPaddleImage.setFitWidth(factor*myPaddleImage.getFitWidth());
    }

    /**
     * Move the paddle to the right
     */
    public void moveRight(){
        myPaddleImage.setX(Math.min(Game.LENGTH - PADDLE_WIDTH,myPaddleImage.getX() + speed));
    }

    /**
     * Move the paddle to the left
     */
    public void moveLeft(){
        myPaddleImage.setX(Math.max(0,myPaddleImage.getX() - speed));
    }

    /**
     * Sets the speed of the paddle
     * @param speed the new speed of the paddle
     */
    public void setSpeed(double speed){
        this.speed = speed;
    }

    /**
     * Gets the speed of the paddle
     * @return the current speed of the paddle
     */
    public double getSpeed(){
        return speed;
    }

    /**
     * Gets the image of the paddle on the display
     * @return the image of the paddle being displayed
     */
    public DisplayImage getMyPaddleImage() {
        return myPaddleImage;
    }

    /**
     * Resets the location of the paddle to be in the center of the screen, like at the start of the game
     */
    public void resetLocation(){
        myPaddleImage.setX(Game.LENGTH / 2.0);
        myPaddleImage.setY(PADDLE_HEIGHT);
    }
}
