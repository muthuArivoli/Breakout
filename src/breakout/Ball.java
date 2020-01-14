package breakout;

import javafx.scene.image.ImageView;

public class Ball {
    public static final double START_X_VELOCITY=100;
    public static final double START_Y_VELOCITY=-100;

    private double xVelocity;
    private double yVelocity;
    private ImageView myBallImage;
    private boolean coupled;

    public Ball(ImageView myBallImage){
        this.myBallImage = myBallImage;
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
        myBallImage.setX(Game.LENGTH/2+Paddle.PADDLE_WIDTH/2-10);
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
    public void uncouple(){
        if(coupled) {
            coupled = false;
            xVelocity = START_X_VELOCITY;
            yVelocity = START_Y_VELOCITY;
        }
    }
    public void moveCoupledLeft(){
        if(coupled){
            myBallImage.setX(myBallImage.getX() - xVelocity);
        }
    }
    public void moveCoupledRight(){
        if(coupled){
            myBallImage.setX(myBallImage.getX() + xVelocity);
        }
    }
    public boolean atBottom(){
        return (myBallImage.getBoundsInParent().getMinY()>Paddle.PADDLE_HEIGHT);
    }
    public boolean inXBounds(){
        return (myBallImage.getBoundsInParent().getMinX()>0 && myBallImage.getBoundsInParent().getMaxX()<Game.LENGTH);
    }
    public boolean inYBounds(){
        return (myBallImage.getBoundsInParent().getMinY()>0 && myBallImage.getBoundsInParent().getMaxY()<Game.WIDTH);
    }

    public ImageView getMyBallImage() {
        return this.myBallImage;
    }
}
