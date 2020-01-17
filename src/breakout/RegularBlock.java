package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This represents the most common type of block that is worth 10 points and takes 1 hit to break.
 */
public class RegularBlock implements Block{
    public static final String REG_BRICK_FILE = "brick1.gif";

    private ImageView myBlock;
    private int hitsToBreak;
    public RegularBlock(String file_name,int xpos, int ypos,int width,Group root){
        myBlock = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(file_name)));
        myBlock.setFitWidth(Game.LENGTH /width-1);
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
    public double getX() {
        return myBlock.getBoundsInLocal().getMinX();
    }
    public double getY() {
        return myBlock.getBoundsInLocal().getMinY();
    }
    public double getWidth() {
        return myBlock.getBoundsInLocal().getMaxX() - getX();
    }
    public double getHeight() {
        return myBlock.getBoundsInLocal().getMaxY() - getY();
    }
    public Bounds getBounds(){
        return myBlock.getBoundsInParent();
    }
    public void destroy(Group root){
        root.getChildren().remove(myBlock);
    }
}
