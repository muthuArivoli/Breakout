package breakout;

import javafx.scene.Group;

/**
 * Represents the overall methods that any special block will have.
 * Depends on Brick
 * @author Muthu Arivoli
 */
public abstract class SpecialBrick implements Brick {
    private Brick myBrick;

    /**
     * Creates the new special brick that will wrap around myBrick
     * @param myBrick the brick that will be wrapped around by this special brick
     */
    SpecialBrick(Brick myBrick){
        this.myBrick = myBrick;
    }

    /**
     * Gets the score of the special brick
     * @return the score the special brick
     */
    public int getScore(){
        return myBrick.getScore();
    }

    /**
     * Gets the number of hits left to break the brick
     * @return the number of hits left to break the brick
     */
    public int getHitsToBreak(){
        return myBrick.getHitsToBreak();
    }

    /**
     * Sets the number of hits left to break the brick
     * @param hitsToBreak the new number of hits to break the brick
     */
    public void setHitsToBreak(int hitsToBreak){
        myBrick.setHitsToBreak(hitsToBreak);
    }

    /**
     * Removes the image of the brick from the display
     * @param root the group that contains all of the objects currently being displayed
     */
    public void destroy(Group root){
        myBrick.destroy(root);
    }

    /**
     * Gets the image of the brick currently being displayed
     * @return the image of the brick being displayed
     */
    public DisplayImage getMyBrickImage() {
        return myBrick.getMyBrickImage();
    }
}
