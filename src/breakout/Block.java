package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public interface Block {
    int getScore();
    int getHitsToBreak();
    void setHitsToBreak(int hitsToBreak);
    ImageView getBlock();
    void destroy(Group root);
}
