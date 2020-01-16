package breakout;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This provides the basic functionality for all powerups.
 * Powerups are dropped from certain special bricks. A player catches the powerup with their paddle, and the powerup
 * gives the player special abilities for a short amount of time. The ability depends on the type of the powerup.
 */
public abstract class Powerup {
    public static final int POWERUPVELOCITY = 3;
    public static final int POWERUPTIME = 6;

    private ImageView myPowerUpImage;
    private double velocity;
    private double timeToExpire;
    Powerup(String file_name,int xpos, int ypos,int width,Group root){
        myPowerUpImage=new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(file_name)));
        myPowerUpImage.setFitWidth((Game.WIDTH/width-1)/2);
        myPowerUpImage.setFitHeight(19/2);
        myPowerUpImage.setX(xpos);
        myPowerUpImage.setY(ypos);
    }
    public void startMoving(Group root){
        root.getChildren().add(myPowerUpImage);
        velocity = POWERUPVELOCITY;
        System.out.println(velocity);
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
