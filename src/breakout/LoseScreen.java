package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

/**
 * This represents the screen that will be displayed when the player loses the game.
 * @author Muthu Arivoli
 */
public class LoseScreen implements Screen {

    private Game myGame;
    private Scorebar myScorebar;
    private Text myText = new Text(Game.LENGTH / 2.0-50,250,"");

    /**
     * Creates the screen that will be displayed when the user loses the game
     * @param myGame the game that has just been lost
     */
    public LoseScreen(Game myGame){
        this.myGame = myGame;
    }

    /**
     * Update the current screen and update score and lives if they change
     * @param elapsedTime amount of time that has elapsed since the last frame
     */
    @Override
    public void update(double elapsedTime) {
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
        myText.setText("You lost." + "\n with a score of: " + myGame.getScore());
    }

    /**
     * Initialize the lost screen and add all relevant elements to the display including the text that will display the lost status.
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    @Override
    public void initialize(Group root) {
        myScorebar = new Scorebar(root);
        root.getChildren().add(myText);
    }

    /**
     * Return the user back to the splash screen after any key has been pressed
     * @param code the key that the user has pressed
     */
    @Override
    public void handleKeyInput(KeyCode code) {
        if (code != null) {
            myGame.setCurrScreen(new SplashScreen(myGame));
        }
    }
}
