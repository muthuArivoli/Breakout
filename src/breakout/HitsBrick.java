package breakout;

/**
 * This represents a brick that takes 2 more hits to break than the original brick.
 * @author Muthu Arivoli
 */
public class HitsBrick extends SpecialBrick {
    public static final String HITS_BLOCK_FILE = "brick2.gif";

    /**
     * Creates a brick that takes two more hits than myBrick.
     * @param myBrick Brick that represents the original brick that will now take two more hits to break
     */
    public HitsBrick(Brick myBrick) {
        super(myBrick);
        setHitsToBreak(getHitsToBreak() + 2);
    }
}
