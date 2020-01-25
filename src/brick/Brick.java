package brick;

import displayImage.DisplayImage;
import javafx.scene.Group;

/**
 * Interface for bricks that can be broken to earn points.
 * @author Muthu Arivoli
 */
public interface Brick {
    /**
     * Gets the score value for the brick
     * @return the score value for the brick
     */
    int getScore();

    /**
     * Gets the number of hits remaining to break the brick
     * @return the number of hits remaining to break the brick
     */
    int getHitsToBreak();

    /**
     * Sets the number of hits remaining to break the brick
     * @param hitsToBreak the new number of hits to break the brick
     */
    void setHitsToBreak(int hitsToBreak);

    /**
     * Removes the brick from the display
     * @param root the group that contains all of the objects currently being displayed
     */
    void destroy(Group root);

    /**
     * Gets the image for the brick itself
     * @return the image for the bricks
     */
    DisplayImage getMyBrickImage();
}
