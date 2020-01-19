package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

/**
 * Interface for screens that will be displayed. Also represents the state that the game is in.
 */
public interface Screen {
    /**
     * Updates the current screen and moves all dynamic elements
     */
    void update(double elapsedTime);

    /**
     * Initializes the screen and adds all elements that need to be displayed to root
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    void initialize(Group root);

    /**
     * Handles any user input through the keyboard by which the user interacts with the game
     * @param code the key that the user has pressed
     */
    void handleKeyInput(KeyCode code);
}
