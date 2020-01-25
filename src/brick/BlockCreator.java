package brick;

import gameObjects.Ball;
import javafx.scene.Group;
import powerup.Powerup;

/**
 * A utility class that is used to create the various types of blocks in the game based on the input from the level file.
 * It depends on the brick interface and its various implementations, including regularBrick, hitsBrick, pointsBrick,
 * powerupBrick, and multipleBallBrick.
 * @author Muthu Arivoli
 */
public class BlockCreator {
    /**
     * Creates a brick that is either a regular brick, hits brick, or a points brick
     * @param in determines what type of brick it is
     * @param xpos is the x coordinate of the top right corner of the brick in the display
     * @param ypos is the y coordinate of the top right corner of the brick in the display
     * @param width is the width of the image of the new brick
     * @param root is the group that keeps track of everything in the display
     * @return the new brick that was created
     */
    public static Brick createBlock(int in, int xpos, int ypos, double width, Group root){
        if(in==1){
            return new RegularBrick(RegularBrick.REG_BRICK_FILE,xpos, ypos, width,root);
        }
        else if(in==2){
            return new HitsBrick(new RegularBrick(HitsBrick.HITS_BLOCK_FILE,xpos, ypos, width,root));
        }
        else {
            return new PointsBrick(new RegularBrick(PointsBrick.POINTS_BLOCK_FILE, xpos, ypos, width, root));
        }
    }


    /**
     * Creates a new powerup brick that releases a powerup upon breaking
     * @param in determines what type of brick it is
     * @param xpos is the x coordinate of the top right corner of the brick in the display
     * @param ypos is the y coordinate of the top right corner of the brick in the display
     * @param width is the width of the image of the new brick
     * @param root is the group that keeps track of everything in the display
     * @param myPowerup is the powerup to attach to this brick that will be released upon being broken
     * @return the new powerup brick that was created
     */
    public static Brick createBlock(int in, int xpos, int ypos, double width, Group root, Powerup myPowerup) {
        return new PowerupBrick(new RegularBrick(PowerupBrick.POWER_BRICK_FILE, xpos, ypos, width, root), myPowerup);
    }

    /**
     * Creates a new multiple ball brick that will release a ball upon breaking
     * @param in determines what type of brick it is
     * @param xpos is the x coordinate of the top right corner of the brick in the display
     * @param ypos is the y coordinate of the top right corner of the brick in the display
     * @param width is the width of the image of the new brick
     * @param root is the group that keeps track of everything in the display
     * @param myNewSecondaryBall is the ball to give this brick that will be released upon being broken
     * @return the new multiple ball brick that was created
     */
    public static Brick createBlock(int in, int xpos, int ypos, double width, Group root, Ball myNewSecondaryBall){
        return new MultipleBallBrick(new RegularBrick(MultipleBallBrick.MULTIPLE_BRICK_FILE, xpos, ypos, width, root),myNewSecondaryBall);
    }
}
