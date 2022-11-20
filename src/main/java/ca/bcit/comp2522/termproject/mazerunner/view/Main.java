package ca.bcit.comp2522.termproject.mazerunner.view;

import ca.bcit.comp2522.termproject.mazerunner.model.Character;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Moving selected character by keyboard.
 *
 * @author Andy & Soo
 * @version 2022
 */
public class Main extends Application {
    /**
     * Distance in pixels that the alien moves when a key is pressed.
     */
    public static final int JUMP = 5;
    Image pokemon = new Image("Pikachu.png", true);
    ImageView imageView = new ImageView(pokemon);
    Character player = new Character(imageView);
    Group root = new Group(player);

    /**
     * Modifies the position of the image view when an arrow key is pressed.
     *
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

    @Override
    public void start(final Stage primaryStage) {
        Scene scene = new Scene(root, 600, 600);
        scene.setOnKeyPressed(this::processKeyPress);
        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
