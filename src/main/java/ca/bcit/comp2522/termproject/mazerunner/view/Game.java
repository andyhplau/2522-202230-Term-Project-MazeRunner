package ca.bcit.comp2522.termproject.mazerunner.view;

import ca.bcit.comp2522.termproject.mazerunner.model.Character;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game{
    public static final int JUMP = 5;
    private Group root;
    private Scene gameScene;
    private Stage gameStage;
    Character player;

    private static final int appWidth = 600;
    private static final int appHeight = 600;

    private Stage selectionStage;

    public Game() {
        initiateStage();
    }

    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> player.moveY(-JUMP);
            case DOWN -> player.moveY(JUMP);
            case RIGHT -> player.moveX(JUMP);
            case LEFT -> player.moveX(-JUMP);
            default -> { }
        }
    }

    public void createNewGame(final Stage selectionStage, final Character player) {
        this.selectionStage = selectionStage;
        this.selectionStage.hide();
        this.player = player;
        root.getChildren().addAll(player);
        gameStage.show();
    }

    public void initiateStage () {
        root = new Group();
        gameScene = new Scene(root, appWidth, appHeight);
        gameScene.setOnKeyPressed(this::processKeyPress);
        gameStage = new Stage();
        gameStage.setTitle("Maze Runner");
        gameStage.setScene(gameScene);
    }
}
