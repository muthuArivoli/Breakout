package breakout;

/**
 * This represents a block that is worth two times the number of points of the block that is given.
 */
public class PointsBlock extends SpecialBlock {
    public static final String POINTS_BLOCK_FILE = "brick3.gif";
    public PointsBlock(Block myBlock){
        super(myBlock);
    }
    public int getScore(){
        return 2*super.getScore();
    }
}
