package breakout;

/**
 * This represents a block that is worth two times the number of points of the block that is given.
 */
public class PointsBrick extends SpecialBrick {
    public static final String POINTS_BLOCK_FILE = "brick3.gif";
    public PointsBrick(Brick myBrick){
        super(myBrick);
    }
    public int getScore(){
        return 2 * super.getScore();
    }
}
