package ca.bcit.comp2522.termproject.mazerunner.view;

import ca.bcit.comp2522.termproject.mazerunner.model.Character;
import ca.bcit.comp2522.termproject.mazerunner.model.Map;
import ca.bcit.comp2522.termproject.mazerunner.model.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Start the game with selected character.
 *
 * @author Andy & Soo
 * @version 2022
 */
public class Game {
    /**
     * Distance in pixels that the alien moves when a key is pressed.
     */
    public static final int JUMP = 5;
    private Timer timer;
    private Group mapPane;
    private Stage gameStage;
    private Character player;
    private Map map;

    private final int appWidth = 600;
    private final int appHeight = 600;

    /**
     * Constructs new game stage.
     */
    public Game() {
        initiateStage();
    }

    /**
     * Moves the position of character.
     * @param event invoked this method
     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> player.moveY(-JUMP);
            case DOWN -> player.moveY(JUMP);
            case RIGHT -> player.moveX(JUMP);
            case LEFT -> player.moveX(-JUMP);
            default -> { }
        }
    }

    private void drawMap() {
        // all coordinates of path
       final int[][] path = {
               {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {14, 1}, {15, 1}, {17, 1}, {18, 1},
               {1, 2}, {2, 2}, {3, 2}, {4, 2}, {7, 2}, {11, 2}, {13, 2}, {15, 2}, {18, 2},
               {4, 3}, {6, 3}, {7, 3}, {9, 3}, {10, 3}, {11, 3}, {13, 3}, {15, 3}, {16, 3}, {18, 3}, {19, 3},
               {1, 4}, {2, 4}, {3, 4}, {4, 4}, {6, 4}, {9, 4}, {13, 4}, {16, 4}, {18, 4},
               {1, 5}, {4, 5}, {5, 5}, {7, 5}, {9, 5}, {10, 5}, {11, 5}, {12, 5}, {13, 5}, {15, 5}, {16, 5}, {17, 5}, {18, 5},
               {1, 6}, {4, 6}, {7, 6}, {9, 6}, {15, 6}, {18, 6},
               {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}, {10, 7}, {11, 7}, {12, 7}, {13, 7}, {14, 7}, {16, 7}, {18, 7},
               {1, 8}, {2, 8}, {4, 8}, {8, 8}, {9, 8}, {14, 8}, {15, 8}, {16, 8}, {18, 8},
               {2, 9}, {4, 9}, {5, 9}, {6, 9}, {9, 9}, {10, 9}, {12, 9}, {13, 9}, {14, 9}, {16, 9}, {18, 9},
               {2, 10}, {4, 10}, {8, 10}, {10, 10}, {12, 10}, {14, 10}, {16, 10}, {18, 10},
               {2, 11}, {4, 11}, {5, 11}, {6, 11}, {8, 11}, {9, 11}, {11, 11}, {12, 11}, {14, 11}, {18, 11},
               {1, 12}, {2, 12}, {3, 12}, {6, 12}, {9, 12}, {10, 12}, {12, 12}, {13, 12}, {16, 12}, {17, 12}, {18, 12},
               {1, 13}, {3, 13}, {4, 13}, {5, 13}, {6, 13}, {7, 13}, {9, 13}, {11, 13}, {13, 13}, {14, 13}, {16, 13}, {18, 13},
               {2, 14}, {3, 14}, {5, 14}, {7, 14}, {9, 14}, {10, 14}, {11, 14}, {14, 14}, {15, 14}, {17, 14}, {18, 14},
               {1, 15}, {3, 15}, {5, 15}, {6, 15}, {7, 15}, {8, 15}, {9, 15}, {11, 15}, {12, 15}, {14, 15}, {18, 15},
               {1, 16}, {2, 16}, {3, 16}, {4, 16}, {5, 16}, {9, 16}, {11, 16}, {13, 16}, {14, 16}, {15, 16}, {16, 16}, {17, 16},
               {1, 17}, {3, 17}, {7, 17}, {9, 17}, {13, 17}, {17, 17}, {18, 17},
               {2, 18}, {3, 18}, {4, 18}, {5, 18}, {6, 18}, {7, 18}, {9, 18}, {10, 18}, {11, 18}, {12, 18}, {13, 18}, {14, 18}, {15, 18}, {16, 18}, {18, 18}, {19, 18}
       };

       // Draw path
        for (int[] ints : path) {
            map.setPath(ints[0], ints[1]);
        }

        // Set three destinations and choose one between them
        map.setDestination(19, 3, "one");
        map.setDestination(10, 10, "two");
        map.setDestination(7, 17, "three");
        map.chooseDestination();
    }

    /**
     * Starts the timer.
     */
    public void startCountTime() {
        timer.startCount();
        timer.setStage(gameStage);
    }

    /**
     * Shows game stage with instantiate the character.
     * @param selectionStage the original stage which will be hided
     * @param pokemonName name of character user chose
     */
    public void createNewGame(final Stage selectionStage, final String pokemonName) {
        selectionStage.hide();
        Image pokemon = new Image(pokemonName + ".png", true);
        ImageView imageView = new ImageView(pokemon);
        this.map = new Map(appWidth, appHeight);
        this.player = new Character(imageView, appWidth, appHeight, this.map);
        mapPane.getChildren().addAll(map, player);
        drawMap();
        player.setDestination();
        gameStage.show();
    }

    /**
     * Initiates game stage.
     */
    public void initiateStage() {
        timer = new Timer(100);
        mapPane = new Group();
        BorderPane root = new BorderPane();
        root.setTop(timer.getTimerPane());
        root.setCenter(mapPane);
        Scene gameScene = new Scene(root, appWidth, appHeight + 50);
        gameScene.setOnKeyPressed(this::processKeyPress);
        gameStage = new Stage();
        gameStage.setTitle("Maze Runner");
        gameStage.setScene(gameScene);
    }
}
