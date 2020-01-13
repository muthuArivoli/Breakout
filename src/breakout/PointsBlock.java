package breakout;


public class PointsBlock extends SpecialBlock {
    public PointsBlock(Block myBlock){
        super(myBlock);
    }
    public int getScore(){
        return 2*super.getScore();
    }
}
