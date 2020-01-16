package breakout;

import javafx.scene.Group;
import javafx.scene.text.Text;


/**
 * This represents the scorebar that will display the total overall score and lives remaining to the user during play.
 */
public class Scorebar {
    private Text myDisplay = new Text(Game.WIDTH/2-50,30,"");
    public Scorebar(Group root){
        root.getChildren().add(myDisplay);
    }
    public void setMyDisplay(int score, int lives){
        myDisplay.setText("Score: " + score + " Lives: " + lives);
    }
}
