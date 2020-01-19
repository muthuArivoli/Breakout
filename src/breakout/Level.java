package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This represents a level in the game. The level is read in from an input file and then handles all interactions
 * between objects present in the level.
 * @author  Muthu Arivoli
 */
public class Level implements Screen{
    private Game myGame;
    private String inputFile;
    private Paddle myPaddle;
    private List<Brick> myBricks = new ArrayList<>();
    private List<Powerup> allPowerups = new ArrayList<>();
    private List<Powerup> activePowerups = new ArrayList<>();
    private List<Ball> myBalls = new ArrayList<>();
    private int myLevel;
    private ScoreMultiplier myScoreMultiplier = new ScoreMultiplier(1);
    private Scorebar myScorebar;
    private Pinball myPinball;

    /**
     * Creates a new level
     * @param myGame the game that the level is being played in
     * @param inputFile the inputFile for the initial state of the level
     * @param myLevel the number of the level
     */
    public Level(Game myGame,String inputFile,int myLevel){
        this.myGame = myGame;
        this.inputFile = inputFile;
        this.myLevel = myLevel;
    }

    /**
     * Initialize the level by creating all relevant objects and reading in the original configuration of blocks from
     * the input file
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    @Override
    public void initialize(Group root) {
        myBalls.add(new Ball());
        myBalls.get(0).initialize(root);
        myPaddle = new Paddle(root);
        myScorebar = new Scorebar(root);
        myPinball = new Pinball(root);
        try {
            Scanner f = new Scanner(new File("resources/"+inputFile));
            int r,c;
            r = f.nextInt();
            c = f.nextInt();
            for(int i = 0;i < r;i++){
                for(int k = 0;k < c; k++){
                    int in = f.nextInt();
                    int xpos = k * (Game.LENGTH / c);
                    int ypos = 20 * i + 80;
                    if(in==4){
                        Powerup newPowerup = createPowerup(in,xpos,ypos,c);
                        allPowerups.add(newPowerup);
                        myBricks.add(BlockCreator.createBlock(in,xpos,ypos,c,root,newPowerup));
                    }
                    else if(in==5){
                        Ball myNewSecondaryBall = new Ball();
                        myBalls.add(myNewSecondaryBall);
                        myBricks.add(BlockCreator.createBlock(in,xpos,ypos,c,root,myNewSecondaryBall));
                    }
                    else if (in!=0){
                        myBricks.add(BlockCreator.createBlock(in, xpos, ypos, c, root));
                    }
                }
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Powerup createPowerup(int in, int xpos, int ypos, int width){
        if(in==4){
            return new PaddleLengthPowerup(xpos,ypos,width,myPaddle);
        }
        else if(in==5){
            return new PaddleSpeedPowerup(xpos,ypos,width,myPaddle);
        }
        else if(in==6){
            return new BallSpeedPowerup(xpos,ypos,width,myBalls.get(0));
        }
        else{
            return new ScoreMultiplierPowerup(xpos,ypos,width,myScoreMultiplier);
        }
    }

    /**
     * Update the current state of the level by updating locations and handling collisions. Also determines if the level
     * needs to change
     * @param elapsedTime amount of time that has elapsed since last frame
     */
    @Override
    public void update(double elapsedTime) {
        updateLocations(elapsedTime);
        updateActivePowerups(elapsedTime);
        updateScorebar();
        handleBallPaddleCollision();
        handleBallBrickCollision();
        handleBallPinballCollision();
        handlePaddlePowerupCollision();
        handleBallDeath();
        handleChangeLevel();
    }

    private void updateLocations(double elapsedTime){
        for(Ball b:myBalls) {
            b.updateLocation(elapsedTime);
        }
        for(Powerup p:allPowerups){
            p.updateLocation();
        }
    }

    /**
     * Updates time that each active powerup still has and removes any powerups that have expired
     * @param elapsedTime amount of time that has elapsed
     */
    private void updateActivePowerups(double elapsedTime){
        Iterator<Powerup> itr = activePowerups.iterator();
        while(itr.hasNext()){
            Powerup activePowerup = itr.next();
            activePowerup.setTimeToExpire(activePowerup.getTimeToExpire() - elapsedTime);
            if(activePowerup.getTimeToExpire()<=0){
                activePowerup.deactivatePowerup();
                itr.remove();
            }
        }
    }
    private void updateScorebar(){
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
    }
    private void handleBallPaddleCollision(){
        for(Ball myBall:myBalls) {
            if (myBall.getMyBallImage().getBounds().intersects(myPaddle.getMyPaddleImage().getBounds())) {
                if(myGame.getScore()>10000){
                    myBall.resetLocation();
                    myPaddle.resetLocation();
                    destroySecondaryBalls();
                    return;
                } else {
                    myBall.setyVelocity(-1 * myBall.getyVelocity());
                    if (myBall.getMyBallImage().getX() < myPaddle.getMyPaddleImage().getX() + Paddle.PADDLE_WIDTH / 3.0 && myBall.getxVelocity() > 0) {
                        myBall.setxVelocity(-1 * myBall.getxVelocity());
                    } else if (myBall.getMyBallImage().getX() > myPaddle.getMyPaddleImage().getX() + 2 * Paddle.PADDLE_WIDTH / 3.0 && myBall.getxVelocity() < 0) {
                        myBall.setxVelocity(-1 * myBall.getxVelocity());
                    }
                }
            }
        }
    }
    private void handleBallBrickCollision(){
        for(Ball myBall:myBalls) {
            if (myBall.isInPlay()) {
                for (int i = 0; i < myBricks.size(); i++) {
                    if (myBricks.get(i).getMyBrickImage().getBounds().intersects(myBall.getMyBallImage().getBounds())) {
                        myBricks.get(i).setHitsToBreak(myBricks.get(i).getHitsToBreak() - 1);
                        if (myBall.getMyBallImage().getMaxX() >= myBricks.get(i).getMyBrickImage().getX() && myBall.getMyBallImage().getX() <= myBricks.get(i).getMyBrickImage().getMaxX()) {
                            myBall.setyVelocity(-1 * myBall.getyVelocity());
                        }
                        if (myBall.getMyBallImage().getY() >= myBricks.get(i).getMyBrickImage().getMaxY() && myBall.getMyBallImage().getMaxY() <= myBricks.get(i).getMyBrickImage().getY()) {
                            myBall.setxVelocity(-1 * myBall.getxVelocity());
                        }
                        if (myBricks.get(i).getHitsToBreak() == 0) {
                            myGame.setScore(myGame.getScore() + myBricks.get(i).getScore() * myScoreMultiplier.getValue());
                            myBricks.get(i).destroy(myGame.getRoot());
                            myBricks.remove(i);
                        }
                        break;
                    }
                }
            }
        }
    }
    private void handleBallPinballCollision(){
        for(Ball myBall:myBalls) {
            if(myBall.getMyBallImage().getBounds().intersects(myPinball.getMyLeftPinballImage().getBounds())){
                handleAngledCollision(myPinball.getLeftAngle(),myBall);
            }
            if(myBall.getMyBallImage().getBounds().intersects(myPinball.getMyRightPinballImage().getBounds())){
                handleAngledCollision(myPinball.getRightAngle(),myBall);
            }
        }
    }
    private void handleAngledCollision(double normal, Ball myBall){
        double angle = 2*normal - Math.toDegrees(Math.atan2(myBall.getyVelocity(), myBall.getxVelocity()));
        double mag = Math.hypot(myBall.getxVelocity(), myBall.getyVelocity());
        myBall.setxVelocity(Math.cos(Math.toRadians(angle))*mag);
        myBall.setyVelocity(Math.sin(Math.toRadians(angle))*mag);
    }
    private void handlePaddlePowerupCollision(){
        Iterator<Powerup> itr = allPowerups.iterator();
        while(itr.hasNext()){
            Powerup myPowerup = itr.next();
            if(myPowerup.getMyPowerupImage().getBounds().intersects(myPaddle.getMyPaddleImage().getBounds())){
                myPowerup.activatePowerup();
                myPowerup.getMyPowerupImage().destroyImage(myGame.getRoot());
                activePowerups.add(myPowerup);
                itr.remove();
            }
        }
    }
    private void handleBallDeath() {
        for (Ball b : myBalls){
            if (b.getMyBallImage().atBottom()) {
                myGame.setLives(myGame.getLives() - 1);
                myPaddle.resetLocation();
                myBalls.get(0).resetLocation();
                destroySecondaryBalls();
                return;
            }
        }
    }
    private void destroySecondaryBalls() {
        Iterator <Ball> itr = myBalls.listIterator(1);
        while(itr.hasNext()){
            Ball myBall = itr.next();
            if(myBall.isInPlay()) {
                myBall.getMyBallImage().destroyImage(myGame.getRoot());
                itr.remove();
            }
        }
    }
    private void handleChangeLevel(){
        if(myBricks.isEmpty()){
            if(myLevel != Game.NUM_LEVELS) {
                System.out.println(myLevel);
            }
            else{
                myGame.setCurrScreen(new WinScreen(myGame));
            }
        }
        if(myGame.getLives()==0){
            myGame.setCurrScreen(new LoseScreen(myGame));
        }
    }

    /**
     * Handles any user input through the keyboard by which the user interacts with the game
     * @param code the key that the user has pressed
     */
    @Override
    public void handleKeyInput(KeyCode code) {
        if (code == KeyCode.RIGHT) {
            myPaddle.moveRight();
            myBalls.get(0).moveCoupledRight();
        }
        else if (code == KeyCode.LEFT) {
            myPaddle.moveLeft();
            myBalls.get(0).moveCoupledLeft();
        }
        else if (code == KeyCode.UP) {
            myPinball.moveUp();
        }
        else if (code == KeyCode.DOWN) {
            myPinball.moveDown();
        }
        else if (code == KeyCode.SPACE){
            myBalls.get(0).uncouple();
        }
        else if (code == KeyCode.L){
            myGame.setLives(myGame.getLives()+1);
        }
        else if (code == KeyCode.R){
            myBalls.get(0).resetLocation();
            destroySecondaryBalls();
            myPaddle.resetLocation();
        }
        else if (code == KeyCode.T){
            myBricks.get(0).destroy(myGame.getRoot());
            myBricks.remove(0);
        }
        else if (code == KeyCode.DIGIT1){
            myGame.setCurrScreen(myGame.getLevel(1));
        }
        else if (code == KeyCode.DIGIT2){
            myGame.setCurrScreen(myGame.getLevel(2));
        }
        else if (code.isDigitKey()){
            myGame.setCurrScreen(myGame.getLevel(3));
        }
        else if (code == KeyCode.U){
            myGame.setScore(myGame.getScore()+10000);
        }
    }
}
