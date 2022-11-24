package ca.bcit.comp2522.termproject.mazerunner.model;

import java.util.Objects;

/**
 * Represents a coordinate in the map.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class Coordinate {
    private final int xCoordinate;
    private final int yCoordinate;
    private boolean accessible;

    /**
     * Constructs a Coordinate object in the map.
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

    /**
     * Updates the accessible value.
     *
     * @param accessible a boolean that represents if this coordinate is accessible for the character
     */
    public void setAccessible(final boolean accessible) {
        this.accessible = accessible;
    }

    /**
     * Compare an object with an AdditionOperation object.
     *
     * @param obj an object
     * @return true if they are the same, else false
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return xCoordinate == other.xCoordinate && yCoordinate == other.yCoordinate && accessible == other.accessible;
    }

    /**
     * Returns a hashCode for this instance of the Coordinate class.
     *
     * @return HashCode as an int
     */
    @Override
    public int hashCode() {
        final int prime = 17;
        final int hashValue = 37;
        int result = prime;
        result = hashValue * result + xCoordinate;
        result = hashValue * result + yCoordinate;
        result = hashValue * result + Objects.hashCode(accessible);
        return result;
    }

    /**
     * Returns a String representation of this Coordinate object.
     *
     * @return description of this Coordinate object
     */
    @Override
    public String toString() {
        return "Coordinate{"
                + "xCoordinate=" + xCoordinate
                + ", yCoordinate=" + yCoordinate
                + ", accessible=" + accessible + '}';
    }
}
