package breakout;

import javafx.scene.Group;

public class BlockCreator {
    public static Brick createBlock(int in, int xpos, int ypos, int c, Group root){
        if(in==1){
            return new RegularBrick(RegularBrick.REG_BRICK_FILE,xpos, ypos,c,root);
        }
        else if(in==2){
            return new HitsBrick(new RegularBrick(HitsBrick.HITS_BLOCK_FILE,xpos, ypos,c,root));
        }
        else {
            return new PointsBrick(new RegularBrick(PointsBrick.POINTS_BLOCK_FILE, xpos, ypos, c, root));
        }
    }
    public static Brick createBlock(int in, int xpos, int ypos, int c, Group root, Powerup myPowerup) {
        return new PowerupBrick(new RegularBrick(PowerupBrick.POWER_BRICK_FILE, xpos, ypos, c, root), myPowerup);
    }
    public static Brick createBlock(int in, int xpos, int ypos, int c, Group root, Ball myNewSecondaryBall){
        return new MultipleBallBrick(new RegularBrick(MultipleBallBrick.MULTIPLE_BRICK_FILE, xpos, ypos, c, root),myNewSecondaryBall);
    }
}
