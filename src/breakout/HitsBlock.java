package breakout;

public class HitsBlock extends SpecialBlock {
    public HitsBlock(Block myBlock){
        super(myBlock);
        setHitsToBreak(getHitsToBreak()+2);
    }
}
