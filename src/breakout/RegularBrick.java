package breakout;

import javafx.scene.Group;

/**
 * This represents the most common type of block that is worth 10 points and takes 1 hit to break.
 */
public class RegularBrick implements Brick {
    public static final String REG_BRICK_FILE = "brick1.gif";

    private DisplayImage myBrickImage;
    private int hitsToBreak;
    public RegularBrick(String file_name, double xpos, double ypos, double width, Group root){
        myBrickImage = new DisplayImage(file_name);
        myBrickImage.setFitWidth(Game.LENGTH /width-1);
        myBrickImage.setFitHeight(19);
        myBrickImage.setX(xpos);
        myBrickImage.setY(ypos);
        myBrickImage.addImage(root);
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
    public void destroy(Group root){
        myBrickImage.destroyImage(root);
    }
    public DisplayImage getMyBrickImage(){
        return myBrickImage;
    }
}
