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
    // Starting point of the character
    private final int offsetX = 30;
    private final int offsetY = 60;

    // Size of the character
    private final int width = 30;
    private final int height = 30;

    // Size of application
    private final int appWidth;
    private final int appHeight;

    private Map map;

    /**
     * Constructs the character user will use.
     *
     * @param imageView image file user will use
     * @param newWidth width of this map
     * @param newHeight height of the map
     * @param thisMap Map which character will be moving
     */
    public Character(final ImageView imageView, final int newWidth, final int newHeight, final Map thisMap) {
        imageView.setX(offsetX);
        imageView.setY(offsetY);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        this.appWidth = newWidth;
        this.appHeight = newHeight;
        this.map = thisMap;

        getChildren().addAll(imageView);
    }

    /**
     * Modifies the x-position of the image.
     *
     * @param x number of movement of x coordinate
     */
    public void moveX(final int x) {
        boolean right = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) {
                if (getTranslateX() < appWidth - offsetX - width
                        && map.findAccessibility(getTranslateX() + width + offsetX, getTranslateY() + offsetY)
                        && getTranslateY() % map.getBoxSize() == 0) {
                    this.setTranslateX(this.getTranslateX() + 1);
                }
            } else {
                if (getTranslateX() > -offsetX
                        && map.findAccessibility(getTranslateX() + offsetX - 1, getTranslateY() + offsetY)
                        && getTranslateY() % map.getBoxSize() == 0) {
                    this.setTranslateX(this.getTranslateX() - 1);
                }
            }
        }

    }

    /**
     * Modifies the y-position of the image.
     *
     * @param y number of movement of y coordinate
     */
    public void moveY(final int y) {
        boolean up = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            if (up) {
                if (getTranslateY() < appHeight - offsetY - height
                        && map.findAccessibility(getTranslateX() + offsetX, getTranslateY() + offsetY + height)
                        && getTranslateX() % map.getBoxSize() == 0) {
                    this.setTranslateY(this.getTranslateY() + 1);
                }
            } else {
                if (getTranslateY() > -offsetY
                        && map.findAccessibility(getTranslateX() + offsetX, getTranslateY() + offsetY - 1)
                        && getTranslateX() % map.getBoxSize() == 0) {
                    this.setTranslateY(this.getTranslateY() - 1);
                }
            }
        }
    }

}
