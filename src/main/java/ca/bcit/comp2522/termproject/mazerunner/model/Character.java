package ca.bcit.comp2522.termproject.mazerunner.model;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.Objects;

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

    private final Map map;
    private int[] chosenDestination;
    private boolean reachDestination;

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
     * Set this game's destination from Map class.
     */
    public void setDestination() {
        this.chosenDestination = map.getChosenDestination();
    }

    /**
     * Get this game's destination from Map class.
     *
     * @return status of character if it reaches the destination or not as a boolean
     */
    public boolean isReachDestination() {
        return reachDestination;
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
                        && getTranslateY() % Coordinate.COORDINATE_WIDTH == 0) {
                    this.setTranslateX(this.getTranslateX() + 1);
                }
            } else {
                if (getTranslateX() > -offsetX
                        && map.findAccessibility(getTranslateX() + offsetX - 1, getTranslateY() + offsetY)
                        && getTranslateY() % Coordinate.COORDINATE_WIDTH == 0) {
                    this.setTranslateX(this.getTranslateX() - 1);
                }
            }
        }
        if (getTranslateX() + offsetX == chosenDestination[0] && getTranslateY() + offsetY == chosenDestination[1]) {
            reachDestination = true;
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
                        && getTranslateX() % Coordinate.COORDINATE_WIDTH == 0) {
                    this.setTranslateY(this.getTranslateY() + 1);
                }
            } else {
                if (getTranslateY() > -offsetY
                        && map.findAccessibility(getTranslateX() + offsetX, getTranslateY() + offsetY - 1)
                        && getTranslateX() % Coordinate.COORDINATE_WIDTH == 0) {
                    this.setTranslateY(this.getTranslateY() - 1);
                }
            }
        }
        if (getTranslateX() + offsetX == chosenDestination[0] && getTranslateY() + offsetY == chosenDestination[1]) {
            reachDestination = true;
        }
    }

    /**
     * Compare an object with a character object.
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

        if (appWidth != character.appWidth) {
            return false;
        }
        if (appHeight != character.appHeight) {
            return false;
        }
        if (reachDestination != character.reachDestination) {
            return false;
        }
        if (!Objects.equals(map, character.map)) {
            return false;
        }
        return Arrays.equals(chosenDestination, character.chosenDestination);
    }

    /**
     * Returns a hashCode for this instance of the character class.
     *
     * @return HashCode as an int
     */
    @Override
    public int hashCode() {
        int result = offsetX;
        final int hashValue = 35;
        result = hashValue * result + offsetY;
        result = hashValue * result + width;
        result = hashValue * result + height;
        result = hashValue * result + appWidth;
        result = hashValue * result + appHeight;
        result = hashValue * result + (map != null ? map.hashCode() : 0);
        result = hashValue * result + Arrays.hashCode(chosenDestination);
        result = hashValue * result + (reachDestination ? 1 : 0);
        return result;
    }

    /**
     * Returns a String representation of this character object.
     *
     * @return description of this character object
     */
    @Override
    public String toString() {
        return "Character{" + "offsetX=" + offsetX + ", offsetY=" + offsetY + ", width=" + width + ", height=" + height
                + ", appWidth=" + appWidth + ", appHeight=" + appHeight + ", map=" + map + ", chosenDestination="
                + Arrays.toString(chosenDestination) + ", reachDestination=" + reachDestination + '}';
    }
}
