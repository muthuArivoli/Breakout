package breakout;

import javafx.scene.Group;

/**
 * This provides the basic functionality for all powerups.
 * Powerups are dropped from certain special bricks. A player catches the powerup with their paddle, and the powerup
 * gives the player special abilities for a short amount of time. The ability depends on the type of the powerup.
 * @author Muthu Arivoli
 */
public abstract class Powerup {
    public static final int POWERUP_VELOCITY = 3;
    public static final int POWERUP_TIME = 6;
    public static final double POWERUP_HEIGHT = 9;

    private DisplayImage myPowerupImage;
    private double velocity;
    private double timeToExpire;

    /**
     * Creates the powerup that will be dropped from the special brick and that will give the player a special ability
     * @param file_name file from which the image of the powerup should be drawn from
     * @param xpos x coordinate of the top right corner of the image
     * @param ypos y coordniate of the top right corner of the image
     * @param width diameter of the powerup
     */
    public Powerup(String file_name,double xpos, double ypos,double width){
        myPowerupImage=new DisplayImage(file_name);
        myPowerupImage.setFitWidth((Game.WIDTH/width-1)/2);
        myPowerupImage.setFitHeight(POWERUP_HEIGHT);
        myPowerupImage.setX(xpos);
        myPowerupImage.setY(ypos);
    }

    /**
     * Add the powerup to the display and start it moving
     * @param root the group that contains all of the objects currently being displayed
     */
    public void startMoving(Group root){
        myPowerupImage.addImage(root);
        velocity = POWERUP_VELOCITY;
    }

    /**
     * Update the location of the powerup as it is moving
     */
    public void updateLocation(){
        myPowerupImage.setY(myPowerupImage.getY()+velocity);
    }

    /**
     * Gets the amount of time left that the powerup is affecting the player
     * @return the amount of time left until the powerup expires
     */
    public double getTimeToExpire(){
        return timeToExpire;
    }

    /**
     * Sets the amount of time left that the powerup is affecting the player
     * @param timeToExpire the amount of time left until the powerup expires
     */
    public void setTimeToExpire(double timeToExpire){
        this.timeToExpire = timeToExpire;
    }

    /**
     * Gets the image that is being displayed for the powerup
     * @return the displayImage that represents the image for the powerup
     */
    public DisplayImage getMyPowerupImage() {
        return myPowerupImage;
    }

    /**
     * This function activates the powerup. Its specific implementation depends on the type of powerup that is being activated.
     */
    public abstract void activatePowerup();

    /**
     * This function deactivates the powerup once it expires. Its specific implementation depends on the type of powerup
     * that is being deactivated.
     */
    public abstract void deactivatePowerup();
}
