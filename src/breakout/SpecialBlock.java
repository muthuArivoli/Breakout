package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;

/**
 * Represents the overall methods that any special block will have.
 */
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
    public double getX(){
        return myBlock.getX();
    }
    public double getY() {
        return myBlock.getY();
    }
    public double getWidth() {
        return myBlock.getWidth();
    }
    public double getHeight() {
        return myBlock.getHeight();
    }
    public Bounds getBounds(){
        return myBlock.getBounds();
    }
    public void destroy(Group root){
        myBlock.destroy(root);
    }
}
