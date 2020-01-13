package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public interface Screen {
    void update(double elapsedTime);
    void initialize(Group root);
    void handleKeyInput(KeyCode code);
}
