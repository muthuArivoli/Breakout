package breakout;

/**
 * This represents a block that takes more hits to break than the original block.
 */
public class HitsBrick extends SpecialBrick {
    public static final String HITS_BLOCK_FILE = "brick2.gif";
    public HitsBrick(Brick myBrick) {
        super(myBrick);
        setHitsToBreak(getHitsToBreak() + 2);
    }
}
