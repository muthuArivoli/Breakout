package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class SpecialBlock implements Block {
    private Block myBlock;
    SpecialBlock(Block myBlock){
        this.myBlock = myBlock;
    }
    public int getScore(){
        return myBlock.getScore();
    }
    public int getHitsToBreak(){
        return myBlock.getHitsToBreak();
    }
    public void setHitsToBreak(int hitsToBreak){
        myBlock.setHitsToBreak(hitsToBreak);
    }
    public ImageView getBlock(){
        return myBlock.getBlock();
    }
    public void destroy(Group root){
        myBlock.destroy(root);
    }
}
