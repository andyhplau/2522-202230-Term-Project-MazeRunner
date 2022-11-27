package ca.bcit.comp2522.termproject.mazerunner.model;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 * Create character user will use.
 *
 * @author Andy & Soo
 * @version 2022
 */
public class Character extends Group {
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final int width = 50;
    private final int height = 50;
    private final int appWidth;
    private final int appHeight;

    /**
     * Constructs the character with passed image.
     *
     * @param imageView image file user will use
     * @param newWidth width of this map
     * @param newHeight height of the map
     */
    public Character(final ImageView imageView, final int newWidth, final int newHeight) {
        imageView.setX(offsetX);
        imageView.setY(offsetY);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        this.appWidth = newWidth;
        this.appHeight = newHeight;

        getChildren().addAll(imageView);
    }

    // Todo: check wall in the map inside the if-statement!
    /**
     * Modifies the x-position of the image.
     *
     * @param x number of movement of x coordinate
     */
    public void moveX(final int x) {
        boolean right = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) {
                if (getTranslateX() < appWidth - offsetX - width) {
                    this.setTranslateX(this.getTranslateX() + 1);
                }
            } else {
                if (getTranslateX() > 0) {
                    this.setTranslateX(this.getTranslateX() - 1);
                }
            }
            System.out.println(getTranslateX() + "," + getTranslateY());
        }
    }

    // Todo: check wall in the map inside the if-statement!
    /**
     * Modifies the y-position of the image.
     *
     * @param y number of movement of y coordinate
     */
    public void moveY(final int y) {
        boolean right = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            if (right) {
                if (getTranslateY() < appHeight - offsetY - height) {
                    this.setTranslateY(this.getTranslateY() + 1);
                }
            } else {
                if (getTranslateY() > 0) {
                    this.setTranslateY(this.getTranslateY() - 1);
                }
            }
            System.out.println(getTranslateX() + "," + getTranslateY());
        }
    }

}
