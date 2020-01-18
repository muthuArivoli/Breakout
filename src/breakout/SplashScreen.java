package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

/**
 * This represents the screen that will be initially displayed to the user that includes the instructions of play.
 * The user pressing any key will then start the first level.
 */
public class SplashScreen implements Screen {
    private Rectangle myMover;
    private Game myGame;

    public SplashScreen(Game myGame){
        this.myGame = myGame;
    }

    @Override
    public void update(double elapsedTime) {

    }

    @Override
    public void initialize(Group root) {
        myMover = new Rectangle(100, 100,100, 100);
        root.getChildren().add(myMover);
    }

    @Override
    public void handleKeyInput(KeyCode code) {
        //User pressing any key will start first level
        if (code != null) {
            myGame.setCurrScreen(myGame.getLevel(1));
        }
    }

}
