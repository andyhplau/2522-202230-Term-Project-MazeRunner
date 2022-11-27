package ca.bcit.comp2522.termproject.mazerunner.model;

import java.util.Objects;

/**
 * Represents a destination in a map.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class Destination extends Coordinate {
    private boolean chosen;

    /**
     * Constructs a Destination object in the map.
     *
     * @param xCoordinate an int that represents the x-coordinate
     * @param yCoordinate an int that represents the y-coordinate
     * @param accessible  a boolean that represents if this coordinate is accessible for the character
     */
    public Destination(final int xCoordinate, final int yCoordinate, final boolean accessible) {
        super(xCoordinate, yCoordinate, accessible);
        this.chosen = false;
    }

    /**
     * Returns if the Destination object is a chosen destination in the map.
     *
     * @return chosen as a boolean
     */
    public boolean isChosen() {
        return chosen;
    }

    /**
     * Updates the chosen value.
     *
     * @param chosen a boolean represents if the destination is chosen by the user
     */
    public void setChosen(final boolean chosen) {
        this.chosen = chosen;
    }

    /**
     * Compare an object with a Destination object.
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
        Destination other = (Destination) obj;
        return xCoordinate == other.xCoordinate
                && yCoordinate == other.yCoordinate
                && accessible == other.accessible
                && chosen == other.chosen;
    }

    /**
     * Returns a hashCode for this instance of the Destination class.
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
        result = hashValue * result + Objects.hashCode(chosen);
        return result;
    }

    /**
     * Returns a String representation of this Destination object.
     *
     * @return description of this Destination object
     */
    @Override
    public String toString() {
        return "Destination{"
                + "xCoordinate=" + xCoordinate
                + ", yCoordinate=" + yCoordinate
                + ", accessible=" + accessible
                + ", chosen=" + chosen + '}';
    }
}
