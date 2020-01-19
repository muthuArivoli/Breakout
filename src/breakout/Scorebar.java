package breakout;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


/**
 * This represents the scorebar that will display the total overall score and lives remaining to the user during play.
 * @author Muthu Arivoli
 */
public class Scorebar {
    private Text myDisplay = new Text(Game.LENGTH / 2.0-50,30,"");

    /**
     * Constructs the scorebar that displays the score at the top of the screen
     * @param root the group that contains all of the objects currently being displayed
     */
    public Scorebar(Group root){
        root.getChildren().add(myDisplay);
        Line myBarrier = new Line(0, 35, Game.WIDTH, 35);
        root.getChildren().add(myBarrier);
    }

    /**
     * Display updated score and number of lives remaining
     * @param score the new score to display
     * @param lives the new number of lives to display
     */
    public void setMyDisplay(int score, int lives){
        myDisplay.setText("Score: " + score + " Lives: " + lives);
    }
}
