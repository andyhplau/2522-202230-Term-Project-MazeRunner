package ca.bcit.comp2522.termproject.mazerunner.model;

import java.util.ArrayList;
import javafx.scene.Group;

public class Map extends Group {
    private final int xSize;
    private final int ySize;
     final int boxSize = Coordinate.COORDINATE_WIDTH;

    private final ArrayList<Coordinate> coordinates = new ArrayList<>();
    private final ArrayList<Destination> destinations = new ArrayList<Destination>();

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

    public void setPath(final int xCoordinate, final int yCoordinate) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getXCoordinate() == xCoordinate * boxSize
                    && coordinate.getYCoordinate() == yCoordinate * boxSize) {
                coordinate.setAccessible(true);
            }
        }
    }

    public void setDestination(final int xCoordinate, final int yCoordinate, final String number) {
        Destination thisDestination =
                new Destination(xCoordinate * boxSize, yCoordinate * boxSize, number);
        destinations.add(thisDestination);
        getChildren().add(thisDestination.getNumView());
    }

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
}
