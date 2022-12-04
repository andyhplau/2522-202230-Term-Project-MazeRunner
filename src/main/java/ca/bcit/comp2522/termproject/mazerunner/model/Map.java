package ca.bcit.comp2522.termproject.mazerunner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.Group;

/**
 * Create Map to let user play the game.
 *
 * @author Andy & Soo
 * @version 2022
 */
public class Map extends Group {
    private final int xSize;
    private final int ySize;
    private final int boxSize = Coordinate.COORDINATE_WIDTH;
    private final ArrayList<Coordinate> coordinates = new ArrayList<>();
    private final ArrayList<Destination> destinations = new ArrayList<>();

    /**
     * Constructs the map.
     *
     * @param newXSize width of this map
     * @param newYSize height of this map
     */
    public Map(final int newXSize, final int newYSize) {
        this.xSize = newXSize;
        this.ySize = newYSize;
        populateCoordinate();
    }

    /**
     * Returns the arraylist of destination.
     *
     * @return destinations as an arraylist
     */
    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    /**
     * Returns the width of this map.
     *
     * @return xSize as an int
     */
    public int getXSize() {
        return xSize;
    }

    /**
     * Returns the height of this map.
     *
     * @return ySize as an int
     */
    public int getYSize() {
        return ySize;
    }

    private void populateCoordinate() {
        int numOfBoxInX = xSize / boxSize;
        int numOfBoxInY = ySize / boxSize;

        for (int i = 0; i < numOfBoxInY; i++) {
            for (int j = 0; j < numOfBoxInX; j++) {
                Coordinate coordinate = new Coordinate(j, i);
                coordinates.add(coordinate);
                getChildren().add(coordinate.getBlockView());
            }
        }
    }

    /**
     * Sets (xCoordinate, yCoordinate) as a path by changing accessibility.
     *
     * @param xCoordinate x coordinate of path as an int
     * @param yCoordinate y coordinate of path as an int
     */
    public void setPath(final int xCoordinate, final int yCoordinate) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getXCoordinate() == xCoordinate * boxSize
                    && coordinate.getYCoordinate() == yCoordinate * boxSize) {
                coordinate.setAccessible(true);
            }
        }
    }

    /**
     * Sets (xCoordinate, yCoordinate) as a destination.
     *
     * @param xCoordinate x coordinate of path as an int
     * @param yCoordinate y coordinate of path as an int
     * @param number the name(number) of destination's image
     */
    public void setDestination(final int xCoordinate, final int yCoordinate, final String number) {
        Destination thisDestination =
                new Destination(xCoordinate, yCoordinate, number);
        destinations.add(thisDestination);
        getChildren().add(thisDestination.getNumView());
    }

    /**
     * Set one destination randomly between three destinations.
     */
    public void chooseDestination() {
        Random random = new Random();
        int randomNum = random.nextInt(1, 4);
        HashMap<Integer, String> stringInt = new HashMap<>();
        stringInt.put(1, "one");
        stringInt.put(2, "two");
        stringInt.put(3, "three");

        for (Destination destination : destinations) {
            if (destination.getDestinationNum().equals(stringInt.get(randomNum))) {
                destination.setChosen(true);
            }
        }
    }

    /**
     * Get coordinate of chosen destination.
     *
     * @return coordinate of chosen destination as list of int, if destination is not chosen yet, return {0, 0}
     */
    public int [] getChosenDestination() {
        int [] chosenDestination = {0, 0};
        for (Destination destination : destinations) {
            if (destination.isChosen()) {
                chosenDestination = new int[]{destination.getXCoordinate(), destination.getYCoordinate()};
            }
        }
        return chosenDestination;
    }

    /**
     * Checks if (xCoordinate, yCoordinate) is path or block.
     *
     * @param xCoordinate x coordinate of path as an int
     * @param yCoordinate y coordinate of path as an int
     *
     * @return accessibility of this coordinate
     */
    public boolean findAccessibility(final double xCoordinate, final double yCoordinate) {
        boolean accessibility = false;
        int newXCoordinate = (int) (xCoordinate / boxSize) * boxSize;
        int newYCoordinate = (int) (yCoordinate / boxSize) * boxSize;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getXCoordinate() == newXCoordinate && coordinate.getYCoordinate() == newYCoordinate) {
                accessibility = coordinate.isAccessible();
            }
        }
        return accessibility;
    }

    /**
     * Compare an object with a Map object.
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

        Map map = (Map) o;

        if (xSize != map.xSize) {
            return false;
        }
        if (ySize != map.ySize) {
            return false;
        }
        if (!coordinates.equals(map.coordinates)) {
            return false;
        }

        return destinations.equals(map.destinations);
    }

    /**
     * Returns a hashCode for this instance of the Map class.
     *
     * @return HashCode as an int
     */
    @Override
    public int hashCode() {
        int result = xSize;
        final int hashValue = 33;
        result = hashValue * result + ySize;
        result = hashValue * result + boxSize;
        result = hashValue * result + coordinates.hashCode();
        result = hashValue * result + destinations.hashCode();
        return result;
    }

    /**
     * Returns a String representation of this Map object.
     *
     * @return description of this Map object
     */
    @Override
    public String toString() {
        return "Map{" +  "xSize=" + xSize + ", ySize=" + ySize + ", boxSize=" + boxSize + ", coordinates="
                + coordinates + ", destinations=" + destinations + '}';
    }
}
