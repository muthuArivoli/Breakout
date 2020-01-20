package breakout;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Transform;

import java.util.Objects;

/**
 * A wrapper class around ImageView that also calculates some more useful measures about the image.
 * @author Muthu Arivoli
 */
public class DisplayImage {
    public static final int MINIMUM_Y_BOUND = 35;
    ImageView myImage;

    /**
     * Creates the new image based on the input file
     * @param fileName the input file used for the image
     */
    public DisplayImage(String fileName){
        myImage = new ImageView(new Image(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(fileName))));
    }

    /**
     * Adds the image to the display
     * @param root Group that contains the elements that are currently being displayed on the screen
     */
    public void addImage(Group root){
        root.getChildren().add(myImage);
    }

    /**
     * Adds a custom transform to the image
     * @param rotate the new transformation that the image can perform
     */
    public void addTransform(Transform rotate){
        myImage.getTransforms().add(rotate);
    }

    /**
     * Sets the width of the image
     * @param val the new width of the image
     */
    public void setFitWidth(double val){
        myImage.setFitWidth(val);
    }

    /**
     * Gets the width of the image
     * @return the width of the image
     */
    public double getFitWidth(){
        return myImage.getFitWidth();
    }

    /**
     * Sets the height of the image
     * @param value the new height of the image
     */
    public void setFitHeight(double value){
        myImage.setFitHeight(value);
    }
    /**
     * Gets the x coordinate of the image
     * @return the x coordinate of the image
     */
    public double getX(){
        return myImage.getX();
    }

    /**
     * Gets the y coordinate of the image
     * @return the y coordinate of the image
     */
    public double getY(){
        return myImage.getY();
    }

    /**
     * Sets the x coordinate of the image
     * @param x the new y coordinate
     */
    public void setX(double x){
        myImage.setX(x);
    }

    /**
     * Sets the y coordinate of the image
     * @param y the new y coordinate
     */
    public void setY(double y){
        myImage.setY(y);
    }

    /**
     * A bound for the rectangular bounding box of the image
     * @return the bounds for the rectangular bounding box
     */
    public Bounds getBounds(){
        return myImage.getBoundsInParent();
    }

    /**
     * Sets the amount that the image is rotated by
     * @param value the new value in degrees that the image is rotated by
     */
    public void setRotate(double value){
        myImage.setRotate(value);
    }

    /**
     * Gets tha maximum x coordinate of the image
     * @return the maximum x coordinate of the image
     */
    public double getMaxX(){
        return myImage.getBoundsInParent().getMaxX();
    }

    /**
     * Gets tha maximum y coordinate of the image
     * @return the maximum y coordinate of the image
     */
    public double getMaxY(){
        return myImage.getBoundsInParent().getMaxY();
    }

    /**
     * Determines whether the image is at the bottom of the screen, beneath the paddle
     * @return whether the image is at the bottom of the screen
     */
    public boolean atBottom(){
        return (getBounds().getMinY()>Paddle.PADDLE_HEIGHT);
    }

    /**
     * Determines whether the image is within the x bounds of the screen
     * @return whether the image is within the x bounds
     */
    public boolean inXBounds(){
        return (getBounds().getMinX()>0 && getBounds().getMaxX()<Game.LENGTH);
    }

    /**
     * Determines whether the image is within the y bounds of the screen
     * @return whether the image is within the y bounds
     */
    public boolean inYBounds(){
        return (getBounds().getMinY()> MINIMUM_Y_BOUND && getBounds().getMaxY()<Game.LENGTH);
    }

    /**
     * Removes the image from the screen
     */
    public void destroyImage(Group root){
        root.getChildren().remove(myImage);
    }
}
