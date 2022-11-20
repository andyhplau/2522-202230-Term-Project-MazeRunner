package ca.bcit.comp2522.termproject.mazerunner.view;

import ca.bcit.comp2522.termproject.mazerunner.model.Character;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private Group root;
    private Stage gameStage;
    private Image pokemon;
    private ImageView imageView;
    private Character player;

    private  final int appWidth = 600;
    private  final int appHeight = 600;

    private Stage selectionStage;

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

    /**
     * Shows game stage with instantiate the character.
     * @param selectionStage the original stage which will be hided
     * @param pokemonName name of character user chose
     */
    public void createNewGame(final Stage selectionStage, final String pokemonName) {
        this.selectionStage = selectionStage;
        this.selectionStage.hide();
        this.pokemon = new Image(pokemonName + ".png", true);
        this.imageView = new ImageView(pokemon);
        this.player = new Character(imageView);
        root.getChildren().addAll(player);
        gameStage.show();
    }

    /**
     * Initiates game stage.
     */
    public void initiateStage() {
        root = new Group();
        Scene gameScene = new Scene(root, appWidth, appHeight);
        gameScene.setOnKeyPressed(this::processKeyPress);
        gameStage = new Stage();
        gameStage.setTitle("Maze Runner");
        gameStage.setScene(gameScene);
    }
}
