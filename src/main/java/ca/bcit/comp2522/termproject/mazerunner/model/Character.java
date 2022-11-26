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
    private final int appWidthHeight = 600;

    /**
     * Constructs the character with passed image.
     *
     * @param imageView image file user will use
     */
    public Character(final ImageView imageView) {
        imageView.setX(offsetX);
        imageView.setY(offsetY);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

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
                if (getTranslateX() < appWidthHeight - offsetX - width) {
                    this.setTranslateX(this.getTranslateX() + 1);
                }
            } else {
                if (getTranslateX() > 0) {
                    this.setTranslateX(this.getTranslateX() - 1);
                }
            }
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
                if (getTranslateY() < appWidthHeight - offsetY - height) {
                    this.setTranslateY(this.getTranslateY() + 1);
                }
            } else {
                if (getTranslateY() > 0) {
                    this.setTranslateY(this.getTranslateY() - 1);
                }
            }
        }
    }

    /**
     * Compare an object with an AdditionOperation object.
     *
     * @param o an object
     * @return true if they are the same, else false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Character character = (Character) o;

        if (offsetX != character.offsetX) {
            return false;
        }
        if (offsetY != character.offsetY) {
            return false;
        }
        if (width != character.width) {
            return false;
        }
        if (height != character.height) {
            return false;
        }
        return appWidthHeight == character.appWidthHeight;
    }

    /**
     * Returns a hashCode for this instance of the character class.
     *
     * @return HashCode as an int
     */
    @Override
    public int hashCode() {
        final int hashValue = 32;
        int result = offsetX;
        result = hashValue * result + offsetY;
        result = hashValue * result + width;
        result = hashValue * result + height;
        result = hashValue * result + appWidthHeight;
        return result;
    }

    /**
     * Returns a String representation of this character object.
     *
     * @return description of this character object
     */
    @Override
    public String toString() {
        return "Character{" + "offsetX=" + offsetX + ", offsetY=" + offsetY + ", width=" + width + ", height="
                + height + ", appWidthHeight=" + appWidthHeight + '}';
    }
}
