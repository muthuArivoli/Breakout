package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This represents the paddle that the player will control to prevent the ball from going out of bounds.
 */
public class Paddle {
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WIDTH = 80;
    public static final int PADDLE_HEIGHT = Game.LENGTH -40;
    public static final String PADDLE_FILE = "paddle.gif";

    private ImageView myPaddleImage;
    private double speed;
    public Paddle(Group root){
        myPaddleImage = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(PADDLE_FILE)));
        myPaddleImage.setFitWidth(PADDLE_WIDTH);
        root.getChildren().add(myPaddleImage);
        speed = PADDLE_SPEED;
        resetLocation();
    }
    public void stretch(double factor){
        myPaddleImage.setFitWidth(factor*myPaddleImage.getFitWidth());
    }
    public void moveRight(){
        myPaddleImage.setX(Math.min(Game.LENGTH - PADDLE_WIDTH,myPaddleImage.getX() + speed));
    }
    public void moveLeft(){
        myPaddleImage.setX(Math.max(0,myPaddleImage.getX() - speed));
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public double getSpeed(){
        return speed;
    }
    public double getX(){
        return myPaddleImage.getX();
    }
    public Bounds getBounds() {
        return myPaddleImage.getBoundsInParent();
    }

    public void resetLocation(){
        myPaddleImage.setX(Game.LENGTH /2);
        myPaddleImage.setY(PADDLE_HEIGHT);
    }
}
