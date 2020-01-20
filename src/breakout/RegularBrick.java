package breakout;

import javafx.scene.Group;

/**
 * This represents the most common type of brick that is worth 10 points and takes 1 hit to break.
 * Depends on Brick
 * @author Muthu Arivoli
 */
public class RegularBrick implements Brick {
    public static final String REG_BRICK_FILE = "brick1.gif";
    public static final int BRICK_HEIGHT = 19;
    public static final int BRICK_OFFSET = 80;

    private DisplayImage myBrickImage;
    private int hitsToBreak;

    /**
     * Creates the regular brick
     * @param file_name file from which image should be drawn from
     * @param xpos x-coordinate of the right corner of the image
     * @param ypos y-coordinate of the left corner of the image
     * @param width width of the image
     * @param root the group that contains all of the objects currently being displayed
     */
    public RegularBrick(String file_name, double xpos, double ypos, double width, Group root){
        myBrickImage = new DisplayImage(file_name);
        myBrickImage.setFitWidth(Game.LENGTH /width-1);
        myBrickImage.setFitHeight(BRICK_HEIGHT);
        myBrickImage.setX(xpos);
        myBrickImage.setY(ypos);
        myBrickImage.addImage(root);
        hitsToBreak = 1;
    }

    /**
     * Return the value of the score of breaking the brick
     * @return the score of breaking the brick
     */
    public int getScore(){
        return 10;
    }

    /**
     * Gets the number of hits remaining to break the brick
     * @return the number of hits remaining
     */
    public int getHitsToBreak() {
        return hitsToBreak;
    }

    /**
     * Sets the number of hits remaining to break the break
     * @param hitsToBreak the new number of hits to break the brick
     */
    public void setHitsToBreak(int hitsToBreak){
        this.hitsToBreak = hitsToBreak;
    }

    /**
     * Removes the image of the brick from the display
     * @param root the group that contains all of the objects currently being displayed
     */
    public void destroy(Group root){
        myBrickImage.destroyImage(root);
    }

    /**
     * Gets the image of the brick on the display
     * @return the image of the brick being displayed
     */
    public DisplayImage getMyBrickImage(){
        return myBrickImage;
    }
}
