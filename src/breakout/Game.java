package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
    public static final String TITLE = "Breakout";
    public static final int WIDTH = 600;
    public static final int LENGTH = 600;
    public static final int FRAMES_PER_SECOND = 60;
    public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static final int NUM_LEVELS = 3;
    public static final Paint BACKGROUND = Color.AZURE;
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WIDTH = 50;
    public static final int PADDLE_HEIGHT = 10;
    public static final String BALL_FILE = "ball.gif";
    private Scene myScene;
    private Group root = new Group();
    private Screen beginScreen = new SplashScreen(this);
    private Screen endScreen;
    private Screen[] myLevels = new Screen[NUM_LEVELS];
    private Screen currScreen;
    private GameState gameState = new GameState(0,3);



    public static void main (String[] args){launch(args);}

    /**
     * Initialize what will be displayed and how it will be updated.
     */
    @Override
    public void start (Stage stage) {
        myScene = new Scene(root, WIDTH, LENGTH, BACKGROUND);
        setCurrScreen(beginScreen);
        for(int level = 0;level < NUM_LEVELS; level++){
            myLevels[level] = new Level(this, "a.txt");
        }
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();

        // attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step (double elapsedTime) {
        currScreen.update(elapsedTime);
    }

    void setCurrScreen(Screen currScreen){
        this.currScreen = currScreen;
        currScreen.initialize(root);
        myScene.setOnKeyPressed(e -> currScreen.handleKeyInput(e.getCode()));
    }

    void setEndScreen(Screen endScreen){
        this.endScreen = endScreen;
    }

    Screen[] getLevels(){
        return myLevels;
    }

    Screen getEndScreen(){
        return endScreen;
    }

    GameState getGameState(){
        return gameState;
    }

}
