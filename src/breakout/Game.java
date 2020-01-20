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

/**
 * The main driver code that initializes the game loop and sets the current screen in the game.
 * Depends on Screen.
 * @author Muthu Arivoli
 */
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

    /**
     * Launch the game
     * @param args used to launch the game
     */
    public static void main (String[] args){launch(args);}

    /**
     * Initialize what will be displayed and how it will be updated.
     */
    @Override
    public void start (Stage stage) {
        myScene = new Scene(root, LENGTH, LENGTH, BACKGROUND);
        setCurrScreen(new SplashScreen(this));
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
        // attach "game loop" to timeline to play it (basically just calling update method on current screen repeatedly forever)
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> currScreen.update(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    /**
     * Sets the state of the game by setting the current screen of the game
     * @param currScreen the new screen that the current screen is set to
     */
    public void setCurrScreen(Screen currScreen){
        this.currScreen = currScreen;
        root.getChildren().clear();
        currScreen.initialize(root);
        myScene.setOnKeyPressed(e -> currScreen.handleKeyInput(e.getCode()));
    }

    /**
     * Creates a new level and return an object to it
     * @param level the number of the new level
     * @return the instance of the new level
     */
    public Screen getLevel(int level){
        return new Level(this,"level"+level+".txt", level);
    }

    /**
     * Gets the number of lives the player has remaining
     * @return the nunmber of lives left
     */
    public int getLives() {
        return lives;
    }

    /**
     * Gets the score of the game
     * @return the score of the game
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the number of lives the player has left
     * @param lives the new number of lives the player has left
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Sets the score
     * @param score the new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the list of items that are currently being displayed on the screen
     * @return the group of objects being displayed
     */
    public Group getRoot(){return this.root;}
}
