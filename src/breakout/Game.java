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

    private Scene myScene;
    private Group root = new Group();
    private Screen currScreen;
    private int score;
    private int lives;

    public static void main (String[] args){launch(args);}

    /**
     * Initialize what will be displayed and how it will be updated.
     */
    @Override
    public void start (Stage stage) {
        score=0;
        lives=3;
        myScene = new Scene(root, WIDTH, LENGTH, BACKGROUND);
        setCurrScreen(new SplashScreen(this));
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
        root.getChildren().clear();
        currScreen.initialize(root);
        myScene.setOnKeyPressed(e -> currScreen.handleKeyInput(e.getCode()));
    }

    Screen getLevel(int level){
        return new Level(this,"level_"+level+".txt", level);
    }
    public int getLives() {
        return lives;
    }
    public int getScore() {
        return score;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Group getRoot(){return this.root;}

}
