package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This represents a level in the game. The level is read in from an input file and then handles all interactions
 * between objects present in the level.
 */
public class Level implements Screen{
    private Game myGame;
    private String inputFile;
    private Paddle myPaddle;
    private List<Block> myBlocks= new ArrayList<>();
    private List<Powerup> allPowerups = new ArrayList<>();
    private List<Powerup> activePowerups = new ArrayList<>();
    private List<Ball> myBalls = new ArrayList<>();
    private int myLevel;
    private ScoreMultiplier myScoreMultiplier = new ScoreMultiplier(1);
    private Scorebar myScorebar;

    Level(Game myGame,String inputFile,int myLevel){
        this.myGame = myGame;
        this.inputFile = inputFile;
        this.myLevel = myLevel;
    }

    @Override
    public void initialize(Group root) {
        myBalls.add(new Ball());
        myBalls.get(0).initialize(root);
        myPaddle = new Paddle(root);
        myScorebar = new Scorebar(root);
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
                        Powerup newPowerup = createPowerup(in,xpos,ypos,c,root);
                        allPowerups.add(newPowerup);
                        myBlocks.add(BlockCreator.createBlock(in,xpos,ypos,c,root,newPowerup));
                    }
                    else if(in==5){
                        Ball myNewSecondaryBall = new Ball();
                        myBalls.add(myNewSecondaryBall);
                        myBlocks.add(BlockCreator.createBlock(in,xpos,ypos,c,root,myNewSecondaryBall));
                    }
                    else if (in!=0){
                        myBlocks.add(BlockCreator.createBlock(in, xpos, ypos, c, root));
                    }
                }
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Powerup createPowerup(int in, int xpos, int ypos, int width, Group root){
        if(in==4){
            return new PaddleLengthPowerup(xpos,ypos,width,root,myPaddle);
        }
        else if(in==5){
            return new PaddleSpeedPowerup(xpos,ypos,width,root,myPaddle);
        }
        else if(in==6){
            return new BallSpeedPowerup(xpos,ypos,width,root,myBalls.get(0));
        }
        else{
            return new ScoreMultiplierPowerup(xpos,ypos,width,root,myScoreMultiplier);
        }
    }

    @Override
    public void update(double elapsedTime) {
        updateLocations(elapsedTime);
        updateActivePowerups(elapsedTime);
        updateScorebar();
        handleBallPaddleCollision();
        handleBallBrickCollision();
        handlePaddlePowerupCollision();
        handleBallDeath();
        handleChangeLevel();
    }

    /**
     * Update locations of the dynamic elements in the level (the ball and moving powerups)
     * @param elapsedTime amount of time that has elapsed
     */
    private void updateLocations(double elapsedTime){
        for(Ball b:myBalls) {
            b.updateLocation(elapsedTime);
        }
        for(Powerup p:allPowerups){
            p.updateLocation();
        }
    }

    /**
     * Updates time that each active powerup still has
     * @param elapsedTime amount of time that has elapsed
     */
    private void updateActivePowerups(double elapsedTime){
        for(int i=0;i<activePowerups.size();i++){
            activePowerups.get(i).setTimeToExpire(activePowerups.get(i).getTimeToExpire() - elapsedTime);
            if(activePowerups.get(i).getTimeToExpire()<=0){
                activePowerups.get(i).deactivatePowerup();
                activePowerups.remove(i);
                i--;
            }
        }
    }
    private void updateScorebar(){
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
    }
    private void handleBallPaddleCollision(){
        for(Ball myBall:myBalls) {
            if (myBall.getMyBallImage().getBounds().intersects(myPaddle.getMyPaddleImage().getBounds())) {
                myBall.setyVelocity(-1 * myBall.getyVelocity());
                if (myBall.getMyBallImage().getX() < myPaddle.getMyPaddleImage().getX() + Paddle.PADDLE_WIDTH / 3.0 && myBall.getxVelocity() > 0) {
                    myBall.setxVelocity(-1 * myBall.getxVelocity());
                } else if (myBall.getMyBallImage().getX() > myPaddle.getMyPaddleImage().getX() + 2 * Paddle.PADDLE_WIDTH / 3.0 && myBall.getxVelocity() < 0) {
                    myBall.setxVelocity(-1 * myBall.getxVelocity());
                }
            }
        }
    }
    private void handleBallBrickCollision(){
        for(Ball myBall:myBalls) {
            if (myBall.isInPlay()) {
                for (int i = 0; i < myBlocks.size(); i++) {
                    if (myBlocks.get(i).getMyBlockImage().getBounds().intersects(myBall.getMyBallImage().getBounds())) {
                        myBlocks.get(i).setHitsToBreak(myBlocks.get(i).getHitsToBreak() - 1);
                        if (myBall.getMyBallImage().getX() + myBall.getMyBallImage().getWidth() >= myBlocks.get(i).getMyBlockImage().getX() && myBall.getMyBallImage().getX() <= myBlocks.get(i).getMyBlockImage().getX() + myBlocks.get(i).getMyBlockImage().getWidth()) {
                            myBall.setyVelocity(-1 * myBall.getyVelocity());
                        }
                        if (myBall.getMyBallImage().getY() >= myBlocks.get(i).getMyBlockImage().getY() + myBlocks.get(i).getMyBlockImage().getHeight() && myBall.getMyBallImage().getY() <= myBlocks.get(i).getMyBlockImage().getY()) {
                            myBall.setxVelocity(-1 * myBall.getxVelocity());
                        }
                        if (myBlocks.get(i).getHitsToBreak() == 0) {
                            myGame.setScore(myGame.getScore() + myBlocks.get(i).getScore() * myScoreMultiplier.getValue());
                            myBlocks.get(i).destroy(myGame.getRoot());
                            myBlocks.remove(i);
                        }
                        break;
                    }
                }
            }
        }
    }
    private void handlePaddlePowerupCollision(){
        for(int i=0;i<allPowerups.size();){
            if(allPowerups.get(i).getMyPowerupImage().getBounds().intersects(myPaddle.getMyPaddleImage().getBounds())){
                allPowerups.get(i).activatePowerup();
                allPowerups.get(i).getMyPowerupImage().destroyImage(myGame.getRoot());
                activePowerups.add(allPowerups.get(i));
                allPowerups.remove(i);
            }
            else{
                i++;
            }
        }
    }
    private void handleBallDeath() {
        for (Ball b : myBalls){
            if (b.getMyBallImage().atBottom()) {
                Ball initialBall = myBalls.get(0);
                myGame.setLives(myGame.getLives() - 1);
                myPaddle.resetLocation();
                initialBall.resetLocation();
                for(int i=1;i< myBalls.size();i++){
                    if(myBalls.get(i).isInPlay()) {
                        myBalls.get(i).getMyBallImage().destroyImage(myGame.getRoot());
                        myBalls.remove(i);
                        i--;
                    }
                }
                break;
            }
        }
    }
    private void handleChangeLevel(){
        if(myBlocks.isEmpty()){
            if(myLevel != Game.NUM_LEVELS) {
                myGame.setCurrScreen(myGame.getLevel(myLevel+1));
            }
            else{
                myGame.setCurrScreen(new WinScreen());
            }
        }
        if(myGame.getLives()==0){
            myGame.setCurrScreen(new LoseScreen());
        }
    }

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
        else if (code == KeyCode.SPACE){
            myBalls.get(0).uncouple();
        }
        else if (code == KeyCode.L){
            myGame.setLives(myGame.getLives()+1);
        }
        else if (code == KeyCode.R){
            myBalls.get(0).resetLocation();
            myPaddle.resetLocation();
        }
        else if (code == KeyCode.T){
            myBlocks.get(0).destroy(myGame.getRoot());
            myBlocks.remove(0);
        }
        else if (code == KeyCode.DIGIT1){
            myGame.setCurrScreen(myGame.getLevel(1));
        }
        else if (code == KeyCode.DIGIT2){
            myGame.setCurrScreen(myGame.getLevel(2));
        }
        else if (code == KeyCode.DIGIT3){
            myGame.setCurrScreen(myGame.getLevel(3));
        }

    }
}
