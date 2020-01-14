package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Powerup {
    public static final int POWERUPVELOCITY = 25;
    public static final int POWERUPTIME = 6;

    private ImageView myPowerUpImage;
    private double velocity;
    private double timeToExpire;
    Powerup(ImageView myPowerUpImage){
        this.myPowerUpImage = myPowerUpImage;
    }
    public void startMoving(Group root){
        root.getChildren().add(myPowerUpImage);
        velocity = POWERUPVELOCITY;
    }
    public void updateLocation(){
        myPowerUpImage.setY(myPowerUpImage.getY()+velocity);
    }
    public double getTimeToExpire(){
        return timeToExpire;
    }
    public void setTimeToExpire(double timeToExpire){
        this.timeToExpire = timeToExpire;
    }
    public abstract void activatePowerup();
    public abstract void deactivatePowerup();
    public void destroyImage(Group root){
        root.getChildren().remove(myPowerUpImage);
    }

    public ImageView getMyPowerUpImage() {
        return this.myPowerUpImage;
    }
}
