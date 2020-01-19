package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Transform;

import java.util.Objects;

public class DisplayImage {
    ImageView myImage;
    public DisplayImage(String fileName){
        myImage = new ImageView(new Image(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(fileName))));
    }
    public void addImage(Group root){
        root.getChildren().add(myImage);
    }
    public void addTransform(Transform rotate){
        myImage.getTransforms().add(rotate);
    }
    public void setFitWidth(double val){
        myImage.setFitWidth(val);
    }
    public double getFitWidth(){
        return myImage.getFitWidth();
    }
    public void setFitHeight(double value){
        myImage.setFitHeight(value);
    }
    public double getX(){
        return myImage.getX();
    }
    public double getY(){
        return myImage.getY();
    }
    public void setX(double x){
        myImage.setX(x);
    }
    public void setY(double y){
        myImage.setY(y);
    }
    public Bounds getBounds(){
        return myImage.getBoundsInParent();
    }
    public double getRotate(){
        return myImage.getRotate();
    }
    public void setRotate(double value){
        myImage.setRotate(value);
    }
    public double getMaxX(){
        return myImage.getBoundsInParent().getMaxX();
    }
    public double getMaxY(){
        return myImage.getBoundsInParent().getMaxY();
    }
    public double getMinX(){
        return myImage.getBoundsInParent().getMinX();
    }
    public double getMinY(){
        return myImage.getBoundsInParent().getMinY();
    }
    public boolean atBottom(){
        return (getBounds().getMinY()>Paddle.PADDLE_HEIGHT);
    }
    public boolean inXBounds(){
        return (getBounds().getMinX()>0 && getBounds().getMaxX()<Game.LENGTH);
    }
    public boolean inYBounds(){
        return (getBounds().getMinY()>35 && getBounds().getMaxY()<Game.LENGTH);
    }
    public void destroyImage(Group root){
        root.getChildren().remove(myImage);
    }
}
