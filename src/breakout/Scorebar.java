package breakout;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


/**
 * This represents the scorebar that will display the total overall score and lives remaining to the user during play.
 */
public class Scorebar {
    private Text myDisplay = new Text(Game.LENGTH /2-50,30,"");
    private Line myBarrier = new Line(0,35,Game.WIDTH,35);
    public Scorebar(Group root){
        root.getChildren().add(myDisplay);
        root.getChildren().add(myBarrier);
    }
    public void setMyDisplay(int score, int lives){
        myDisplay.setText("Score: " + score + " Lives: " + lives);
    }
}
