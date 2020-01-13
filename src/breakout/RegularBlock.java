package breakout;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class RegularBlock implements Block{
    private ImageView myBlock;
    private int hitsToBreak;
    public RegularBlock(ImageView myBlock){
        this.hitsToBreak = 1;
        this.myBlock = myBlock;
    }
    public int getScore(){
        return 10;
    }
    public int getHitsToBreak() {
        return hitsToBreak;
    }
    public void setHitsToBreak(int hitsToBreak){
        this.hitsToBreak = hitsToBreak;
    }
    public ImageView getBlock(){
        return myBlock;
    }
    public void destroy(Group root){
        root.getChildren().remove(myBlock);
    }
}
