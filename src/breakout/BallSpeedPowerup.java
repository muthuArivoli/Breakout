package breakout;

/**
 * This represents a powerup that temporarily speeds up the main (initial) ball for a short amount of time.
 */
public class BallSpeedPowerup extends Powerup{
    public static final double BALL_SPEED_FACTOR = 2.0;
    public static final String BALL_SPEED_FILE = "extraballpower.gif";
    private Ball myBall;
    public BallSpeedPowerup(int xpos, int ypos, int width, Ball myBall){
        super(BALL_SPEED_FILE,xpos,ypos,width);
        this.myBall = myBall;
    }
    @Override
    public void activatePowerup() {
        myBall.setxVelocity(myBall.getxVelocity()/BALL_SPEED_FACTOR);
        myBall.setyVelocity(myBall.getyVelocity()/BALL_SPEED_FACTOR);
        setTimeToExpire(POWERUPTIME);
    }

    @Override
    public void deactivatePowerup() {
        myBall.setxVelocity(myBall.getxVelocity()*BALL_SPEED_FACTOR);
        myBall.setyVelocity(myBall.getyVelocity()*BALL_SPEED_FACTOR);
    }
}
