package ca.bcit.comp2522.termproject.mazerunner.model;

import java.util.ArrayList;
import javafx.scene.Group;

public class Map extends Group {
    private final int xSize;
    private final int ySize;
    private final int boxSize = 50;

    private final ArrayList<Coordinate> Coordinates = new ArrayList<>();
    private final ArrayList<Destination> Destinations = new ArrayList<Destination>();

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
        return Destinations;
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
                Coordinates.add(coordinate);
                getChildren().add(coordinate.getBlockView());
            }
        }
    }

    public void setPath(final int xCoordinate, final int yCoordinate) {
        for (Coordinate coordinate : Coordinates) {
            if (coordinate.getXCoordinate() == xCoordinate && coordinate.getYCoordinate() == yCoordinate) {
                coordinate.setAccessible(true);
            }
        }
    }

    public boolean findAccessibility(final int xCoordinate, final int yCoordinate) {
        boolean accessibility = false;
        for (Coordinate coordinate : Coordinates) {
            if (coordinate.getXCoordinate() == xCoordinate && coordinate.getYCoordinate() == yCoordinate) {
                accessibility = coordinate.isAccessible();
            }
        }
        return accessibility;
    }
}
