package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

/**
 * This represents the screen that will be displayed when the user wins the game.
 * Depends on Game and Scorebar.
 * @author Muthu Arivoli
 */
public class WinScreen implements Screen {
    public static final double WIN_TEXT_X_POSITION = Game.LENGTH / 2.0 - 50;
    public static final int WIN_TEXT_Y_POSITION = 250;
    private Game myGame;
    private Scorebar myScorebar;
    private Text myText = new Text(WIN_TEXT_X_POSITION, WIN_TEXT_Y_POSITION,"");

    /**
     * Creates the screen that will be displayed when the user wins the game
     * @param myGame the game that has just been won
     */
    public WinScreen(Game myGame){
        this.myGame = myGame;
    }

    /**
     * Update the current screen and update score and lives if they change
     * @param elapsedTime amount of time that has elapsed since the last frame
     */
    @Override
    public void update(double elapsedTime) {
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
        myText.setText("YOU WON !!!" + "\n with a score of: " + myGame.getScore() + "\n and " + myGame.getLives() +" lives remaining");
    }

    /**
     * Initialize the win screen and add all relevant elements to the display including the text that will display the win status.
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
        if (code == KeyCode.SPACE) {
            myGame.setCurrScreen(new SplashScreen(myGame));
        }
    }
}
