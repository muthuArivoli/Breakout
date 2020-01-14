package breakout;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class Level implements Screen{
    private Game myGame;
    private String inputFile;
    private Ball myBall;
    private Paddle myPaddle;
    private List<Block> myBlocks= new ArrayList<>();
    private List<Powerup> allPowerups = new ArrayList<>();
    private List<Powerup> activePowerups = new ArrayList<>();
    private int myLevel;
    private ScoreMultiplier myScoreMultiplier = new ScoreMultiplier(1);
    private Scorebar myScorebar;
    Level(Game myGame,String inputFile,int myLevel){
        this.myGame = myGame;
        this.inputFile = inputFile;
        this.myLevel = myLevel;
    }

    @Override
    public void initialize(Group root){
        //read file, store blocks, store powerups
        int[][] ary = {{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1}};
        for(int i=0;i<ary.length;i++){
            for(int k=0;k<ary[0].length;k++){
                if(ary[i][k]==1){
                    ImageView myBlockPicture = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(Game.REG_BRICK_FILE)));
                    myBlockPicture.setFitWidth(Game.WIDTH/ary[i].length-1);
                    myBlockPicture.setFitHeight(19);
                    myBlockPicture.setX(k*(Game.WIDTH/ary[i].length));
                    myBlockPicture.setY(i*20+Game.LENGTH/2);
                    myBlocks.add(new RegularBlock(myBlockPicture));
                    root.getChildren().add(myBlockPicture);
                }
            }
        }
        //create ball
        ImageView ball_image = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(Game.BALL_FILE)));
        myBall = new Ball(ball_image);
        myBall.resetLocation();
        root.getChildren().add(ball_image);
        //create paddle
        ImageView paddle_image =new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(Game.PADDLE_FILE)));
        myPaddle = new Paddle(paddle_image);
        myPaddle.resetLocation();
        root.getChildren().add(paddle_image);

        myScorebar = new Scorebar(root);
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
    }

    @Override
    public void update(double elapsedTime) {
        myBall.updateLocation(elapsedTime);
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
        for(Powerup p:allPowerups){
            p.updateLocation();
        }
        //BALL and PADDLE
        if(myBall.getMyBallImage().getBoundsInParent().intersects(myPaddle.getMyPaddleImage().getBoundsInParent())){
            myBall.setyVelocity(-1*myBall.getyVelocity());
        }
        //BALL and BRICK
        for(int i=0;i<myBlocks.size();i++){
            if(myBlocks.get(i).getBlock().getBoundsInParent().intersects(myBall.getMyBallImage().getBoundsInParent())){
                myBlocks.get(i).setHitsToBreak(myBlocks.get(i).getHitsToBreak()-1);
                if(myBlocks.get(i).getHitsToBreak()==0) {
                    myGame.setScore(myGame.getScore() + myBlocks.get(i).getScore()*myScoreMultiplier.getValue());
                    myBlocks.get(i).destroy(myGame.getRoot());
                    myBlocks.remove(i);
                }
                myBall.setyVelocity(-1*myBall.getyVelocity());
                break;
            }
        }

        //PADDLE and POWERUP
        for(int i=0;i<allPowerups.size();){
            if(allPowerups.get(i).getMyPowerUpImage().getBoundsInParent().intersects(myPaddle.getMyPaddleImage().getBoundsInParent())){
                allPowerups.get(i).activatePowerup();
                allPowerups.get(i).destroyImage(myGame.getRoot());
                activePowerups.add(allPowerups.get(i));
                allPowerups.remove(i);
            }
            else{
                i++;
            }
        }

        if(myBall.atBottom()){
            myGame.setLives(myGame.getLives()-1);
            myPaddle.resetLocation();
            myBall.resetLocation();
        }
        for(int i=0;i<activePowerups.size();i++){
            activePowerups.get(i).setTimeToExpire(activePowerups.get(i).getTimeToExpire() - elapsedTime);
            if(activePowerups.get(i).getTimeToExpire()<=0){
                activePowerups.get(i).deactivatePowerup();
                activePowerups.remove(i);
                i--;
            }
        }
        myScorebar.setMyDisplay(myGame.getScore(),myGame.getLives());
        handleChangeLevel();
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
            myBall.moveCoupledRight();
        }
        else if (code == KeyCode.LEFT) {
            myPaddle.moveLeft();
            myBall.moveCoupledLeft();
        }
        else if (code == KeyCode.SPACE){
            myBall.uncouple();
        }
        else if (code == KeyCode.L){
            myGame.setLives(myGame.getLives()+1);
        }
        else if (code == KeyCode.R){
            myBall.resetLocation();
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
