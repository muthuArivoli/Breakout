package breakout;

import javafx.scene.Group;

/**
 * Represents the overall methods that any special block will have.
 */
public abstract class SpecialBrick implements Brick {
    private Brick myBrick;
    SpecialBrick(Brick myBrick){
        this.myBrick = myBrick;
    }
    public int getScore(){
        return myBrick.getScore();
    }
    public int getHitsToBreak(){
        return myBrick.getHitsToBreak();
    }
    public void setHitsToBreak(int hitsToBreak){
        myBrick.setHitsToBreak(hitsToBreak);
    }
    public void destroy(Group root){
        myBrick.destroy(root);
    }
    public DisplayImage getMyBrickImage() {
        return myBrick.getMyBrickImage();
    }
}
