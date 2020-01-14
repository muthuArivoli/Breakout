package breakout;

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
