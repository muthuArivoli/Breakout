package breakout;


/**
 * This represents the number by which any points that are gained are multiplied by.
 */
public class ScoreMultiplier {
    private int value;
    public ScoreMultiplier(int myScoreMultiplier){
        this.value = myScoreMultiplier;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
