package breakout;

import javafx.scene.image.ImageView;

public class Ball {
    private double xVelocity;
    private double yVelocity;
    private ImageView myBall;

    public Ball(ImageView myBall, int xVelocity,int yVelocity){
        this.myBall = myBall;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
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
    public void updateLocation(double elapsedTime){
        if(!inXBounds()) {
            this.xVelocity *= -1;
        }
        myBall.setX(myBall.getX() + this.xVelocity*elapsedTime);
        if(!inYBounds()) {
            this.yVelocity *= -1;
        }
        myBall.setY(myBall.getY() + this.yVelocity*elapsedTime);
    }

    public boolean inXBounds(){
        return (myBall.getBoundsInParent().getMinX()>0 && myBall.getBoundsInParent().getMaxX()<Game.LENGTH);
    }
    public boolean inYBounds(){
        return (myBall.getBoundsInParent().getMinY()>0 && myBall.getBoundsInParent().getMaxY()<Game.WIDTH);
    }


}
