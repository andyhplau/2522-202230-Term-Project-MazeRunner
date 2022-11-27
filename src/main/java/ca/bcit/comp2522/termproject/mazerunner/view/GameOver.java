package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents a game over page when user lose.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class GameOver {
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 650;
    private final BorderPane root;
    private final Stage stage;
    private Stage gameStage;


    /**
     * Constructs the GameOver object.
     */
    public GameOver() {
        root = new BorderPane();
        setUpCenter();
        setUpNav();

        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        stage = new Stage();
        stage.setTitle("Maze Runner");
        stage.setScene(scene);
    }

    private void setUpCenter() {
        final int msgSpacing = 10;
        final Font msgFontSize = Font.font(30);
        final Font gameOverFontSize = Font.font(50);
        final VBox msgBox = new VBox(msgSpacing);
        Text timesUpMsg = new Text("Time is up!");
        timesUpMsg.setFont(msgFontSize);
        Text descriptionMsg = new Text("Your character cannot escape in time!\nIt will trap in this maze forever...");
        descriptionMsg.setFont(msgFontSize);
        Text gameOverMsg = new Text("Game Over!");
        gameOverMsg.setFont(gameOverFontSize);
        gameOverMsg.setFill(Color.RED);
        msgBox.getChildren().addAll(timesUpMsg, descriptionMsg, gameOverMsg);
        msgBox.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        StackPane centerPane = new StackPane(msgBox);
        root.setCenter(centerPane);
    }

    private void setUpNav() {
        final int bottomHeight = 100;
        final Font buttonFont = Font.font(20);
        Button playAgainButton = new Button("Start Again!");
        playAgainButton.setFont(buttonFont);
//        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(final ActionEvent actionEvent) {
//                Game newGame = new Game();
//                newGame.createNewGame(gameStage, "pikachu");
//                newGame.startCountTime();
//            }
//        });
        StackPane bottomPane = new StackPane(playAgainButton);
        bottomPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        bottomPane.setPrefHeight(bottomHeight);
        root.setBottom(bottomPane);
    }

    /**
     * Changes the game stage to game over stage.
     *
     * @param gameStage the game stage which will be hided as a Stage
     */
    public void gameIsOver(final Stage gameStage) {
        this.gameStage = gameStage;
        this.gameStage.hide();
        stage.show();
    }

}
