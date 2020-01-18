package breakout;

import javafx.scene.Group;

/**
 * Interface for blocks that can be broken to earn points.
 */
public interface Brick {
    int getScore();
    int getHitsToBreak();
    void setHitsToBreak(int hitsToBreak);
    void destroy(Group root);
    DisplayImage getMyBrickImage();
}
