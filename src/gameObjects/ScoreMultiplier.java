package gameObjects;


/**
 * This represents the number by which any points that are gained are multiplied by.
 * @author Muthu Arivoli
 */
public class ScoreMultiplier {
    private int value;

    /**
     * Creates the score multiplier that will multiply the score being gained in the game
     * @param myScoreMultiplier the
     */
    public ScoreMultiplier(int myScoreMultiplier){
        this.value = myScoreMultiplier;
    }

    /**
     * Gets the score multiplier value
     * @return the score multiplier value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the value of the score multiplier
     * @param value the new value of the score multiplier
     */
    public void setValue(int value) {
        this.value = value;
    }
}
