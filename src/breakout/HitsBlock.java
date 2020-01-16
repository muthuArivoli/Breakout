package breakout;

/**
 * This represents a block that takes more hits to break than the original block.
 */
public class HitsBlock extends SpecialBlock {
    public HitsBlock(Block myBlock){
        super(myBlock);
        setHitsToBreak(getHitsToBreak()+2);
    }
}
