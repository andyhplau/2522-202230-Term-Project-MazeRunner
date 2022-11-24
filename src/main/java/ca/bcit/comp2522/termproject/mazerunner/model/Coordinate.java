package ca.bcit.comp2522.termproject.mazerunner.model;

/**
 * Represents a coordinate in the map.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class Coordinate {
    private final int xCoordinate;
    private final int yCoordinate;
    private final boolean accessible;

    /**
     * Constructs a coordinate in the map.
     *
     * @param xCoordinate an int that represents the x-coordinate
     * @param yCoordinate an int that represents the y-coordinate
     * @param accessible a boolean that represents if this coordinate is accessible for the character
     */
    public Coordinate(final int xCoordinate, final int yCoordinate, final boolean accessible) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.accessible = accessible;
    }

    /**
     * Returns the x-coordinate.
     *
     * @return xCoordinate as an int
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return yCoordinate as an int
     */
    public int getyYCoordinate() {
        return yCoordinate;
    }

    /**
     * Returns if the coordinate is accessible for the character.
     *
     * @return accessible as a boolean
     */
    public boolean isAccessible() {
        return accessible;
    }
}
