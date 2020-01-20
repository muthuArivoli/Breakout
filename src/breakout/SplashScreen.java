package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

/**
 * This represents the screen that will be initially displayed to the user that includes the instructions of play.
 * The user pressing any key will then start the first level.
 * Depends on Game
 * @author Muthu Arivoli
 */
public class SplashScreen implements Screen {
    public static final int TEXT_X_POSITION = 50;
    public static final int TEXT_Y_POSITION = 100;
    private Game myGame;
    Text myText;
    /**
     * Creates the screen that will be displayed when the user starts the game
     * @param myGame the game that has just been started
     */
    public SplashScreen(Game myGame){
        this.myGame = myGame;
    }

    /**
     * Update the current screen and update score and lives if they change
     * @param elapsedTime amount of time that has elapsed since the last frame
     */
    @Override
    public void update(double elapsedTime) {
        myText.setText("Welcome to BREAKOUT-Pinball v2 \n" +
                "The rules are simple, use the arrow keys to move the paddle and the pinball striker around. \n" +
                "If the ball touches the bottom of the screen, you will lose a life. Be warned - you only get 3 lives \n" +
                "To clear a level, you must break all of the bricks in the level. Some bricks will perform different actions \n" +
                "and some will drop powerups that you can catch with your paddle to assist you in your journey to win! \n \n" +
                "Blue Bricks are worth 10 points \n" +
                "Green Bricks take 3 hits to break and are worth 10 points \n" +
                "Gray Bricks are worth 20 points\n" +
                "Purple Bricks will release a powerup once broken and are worth 10 points\n" +
                "Gold Bricks will release another ball once broken and are worth 10 points\n\n" +
                "Green Powerups slow down the main ball for a while \n" +
                "Blue Powerups increase the speed of the paddle for a short while \n" +
                "Yellow Powerups will multiply any gained score by 2 for a while\n" +
                "Red Powerups increase the size of the paddle for a while \n\n" +
                "Finally, if you are able to accrue 10000 points, you will gain the special ability of being able \n" +
                "to hold the ball with your paddle\n" +
                "PRESS ANY KEY TO CONTINUE");
    }

    /**
     * Initialize the lost screen and add all relevant elements to the display including the text that will display the instructions.
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    @Override
    public void initialize(Group root) {
        myGame.setScore(0);
        myGame.setLives(3);
        myText = new Text(TEXT_X_POSITION, TEXT_Y_POSITION,"");
        root.getChildren().add(myText);
    }

    /**
     * Return the user to level 1 after any key has been pressed
     * @param code the key that the user has pressed
     */
    @Override
    public void handleKeyInput(KeyCode code) {
        if (code != null) {
            myGame.setCurrScreen(myGame.getLevel(1));
        }
    }

}
