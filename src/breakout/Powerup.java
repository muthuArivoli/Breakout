package breakout;

import javafx.scene.Group;

/**
 * This provides the basic functionality for all powerups.
 * Powerups are dropped from certain special bricks. A player catches the powerup with their paddle, and the powerup
 * gives the player special abilities for a short amount of time. The ability depends on the type of the powerup.
 */
public abstract class Powerup {
    public static final int POWERUPVELOCITY = 3;
    public static final int POWERUPTIME = 6;

    private DisplayImage myPowerupImage;
    private double velocity;
    private double timeToExpire;
    public Powerup(String file_name,double xpos, double ypos,double width){
        myPowerupImage=new DisplayImage(file_name);
        myPowerupImage.setFitWidth((Game.LENGTH /width-1)/2);
        myPowerupImage.setFitHeight(18.0/2);
        myPowerupImage.setX(xpos);
        myPowerupImage.setY(ypos);
    }
    public void startMoving(Group root){
        myPowerupImage.addImage(root);
        velocity = POWERUPVELOCITY;
        System.out.println(velocity);
    }
    public void updateLocation(){
        myPowerupImage.setY(myPowerupImage.getY()+velocity);
    }
    public double getTimeToExpire(){
        return timeToExpire;
    }
    public void setTimeToExpire(double timeToExpire){
        this.timeToExpire = timeToExpire;
    }
    public DisplayImage getMyPowerupImage() {
        return myPowerupImage;
    }
    public abstract void activatePowerup();
    public abstract void deactivatePowerup();
}
