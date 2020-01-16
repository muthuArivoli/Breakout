package breakout;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RegularBlock implements Block{
    public static final String REG_BRICK_FILE = "brick1.gif";

    private ImageView myBlock;
    private int hitsToBreak;
    public RegularBlock(String file_name,int xpos, int ypos,int width,Group root){
        myBlock = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(file_name)));
        myBlock.setFitWidth(Game.WIDTH/width-1);
        myBlock.setFitHeight(19);
        myBlock.setX(xpos);
        myBlock.setY(ypos);
        root.getChildren().add(myBlock);
        hitsToBreak = 1;
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
