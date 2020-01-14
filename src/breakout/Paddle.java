package breakout;

import javafx.scene.image.ImageView;

public class Paddle {
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WIDTH = 50;
    public static final int PADDLE_HEIGHT = Game.WIDTH-40;

    private ImageView myPaddleImage;
    private double speed;
    public Paddle(ImageView myPaddleImage){
        myPaddleImage.setFitWidth(PADDLE_WIDTH);
        this.myPaddleImage = myPaddleImage;
        this.speed = PADDLE_SPEED;
    }
    public void stretch(double factor){
        myPaddleImage.setFitWidth(factor*myPaddleImage.getFitWidth());
    }
    public void moveRight(){
        myPaddleImage.setX(Math.min(Game.WIDTH - PADDLE_WIDTH,myPaddleImage.getX() + speed));
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

    public ImageView getMyPaddleImage() {
        return this.myPaddleImage;
    }

    public void resetLocation(){
        myPaddleImage.setX(Game.LENGTH/2);
        myPaddleImage.setY(PADDLE_HEIGHT);
    }
}
