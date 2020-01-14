package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

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
        if(code!=null){
            myGame.setCurrScreen(myGame.getLevel(1));
        }
    }

}
