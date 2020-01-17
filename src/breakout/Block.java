package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;

/**
 * Interface for blocks that can be broken to earn points.
 */
public interface Block {
    int getScore();
    int getHitsToBreak();
    void setHitsToBreak(int hitsToBreak);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    Bounds getBounds();
    void destroy(Group root);
}
