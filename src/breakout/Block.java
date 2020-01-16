package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 * Interface for blocks that can be broken to earn points.
 */
public interface Block {
    int getScore();
    int getHitsToBreak();
    void setHitsToBreak(int hitsToBreak);
    ImageView getBlock();
    void destroy(Group root);
}
