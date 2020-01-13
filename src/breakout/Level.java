package breakout;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

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

    Level(Game myGame,String inputFile,int myLevel){
        this.myGame = myGame;
        this.inputFile = inputFile;
        this.myLevel = myLevel;
    }

    @Override
    public void initialize(Group root){
        root.getChildren().clear();
        //read file, store blocks, store powerups
        //create ball
        myBlocks.add(new RegularBlock(new Rectangle(2,3)));
        ImageView ball_image = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream(Game.BALL_FILE)));
        ball_image.setX(Game.LENGTH/2);
        ball_image.setY(Game.WIDTH/2);
        myBall = new Ball(ball_image,100,-50);
        root.getChildren().add(ball_image);
        //create paddle
        Rectangle paddle_image = new Rectangle((Game.LENGTH-Paddle.PADDLE_WIDTH)/2, Game.WIDTH-50,Paddle.PADDLE_WIDTH,Paddle.PADDLE_HEIGHT);
        myPaddle = new Paddle(paddle_image);
        root.getChildren().add(paddle_image);
    }

    @Override
    public void update(double elapsedTime) {
        myBall.updateLocation(elapsedTime);
        for(Powerup p:allPowerups){
            p.updateLocation();
        }



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
        }
        else if (code == KeyCode.LEFT) {
            myPaddle.moveLeft();
        }
    }
}
