package brick;

/**
 * This represents a block that is worth two times the number of points of the block that is given.
 * Depends on SpecialBrick
 * @author  Muthu Arivoli
 */
public class PointsBrick extends SpecialBrick {
    public static final String POINTS_BLOCK_FILE = "brick3.gif";

    /**
     * Create a new brick that will be worth twice as much points
     * @param myBrick the brick that will be worth twice as much points
     */
    public PointsBrick(Brick myBrick){
        super(myBrick);
    }

    /**
     * Gets the score of this brick, which is twice as many points as the brick it defined
     * @return the score of the points brick
     */
    public int getScore(){
        return 2 * super.getScore();
    }
}
