package breakout;

import javafx.scene.Group;

public class BlockCreator {
    public static Block createBlock(int in, int xpos, int ypos, int c, Group root){
        if(in==1){
            return new RegularBlock(RegularBlock.REG_BRICK_FILE,xpos, ypos,c,root);
        }
        else if(in==2){
            return new HitsBlock(new RegularBlock(HitsBlock.HITS_BLOCK_FILE,xpos, ypos,c,root));
        }
        else {
            return new PointsBlock(new RegularBlock(PointsBlock.POINTS_BLOCK_FILE, xpos, ypos, c, root));
        }
    }
    public static Block createBlock(int in, int xpos, int ypos, int c, Group root, Powerup myPowerup) {
        return new PowerupBlock(new RegularBlock(PowerupBlock.POWER_BRICK_FILE, xpos, ypos, c, root), myPowerup);
    }
    public static Block createBlock(int in, int xpos, int ypos, int c, Group root, Ball myNewSecondaryBall){
        return new MultipleBallBlock(new RegularBlock(MultipleBallBlock.MULTIPLE_BRICK_FILE, xpos, ypos, c, root),myNewSecondaryBall);
    }
}
