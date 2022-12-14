package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Represents a page when the game ends.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class EndGame {
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 650;
    private final BorderPane root;
    private final Stage stage;

    /**
     * Constructs the EndGame object.
     *
     * @param finishMsg the msg to show if the user win or lose as a Text
     * @param descriptionMsg the msg to describe the game as a Text
     * @param endMsg The message to tell user what they can do next step as a Text
     * @param playAgainButton the button to let user start the game again as a Button
     */
    public EndGame(final Text finishMsg, final Text descriptionMsg, final Text endMsg, final Button playAgainButton) {
        root = new BorderPane();
        setUpCenter(finishMsg, descriptionMsg, endMsg);
        setUpNav(playAgainButton);

        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        stage = new Stage();
        stage.setTitle("Maze Runner");
        stage.setScene(scene);
    }

    private void setUpCenter(final Text finishMsg, final Text descriptionMsg, final Text endMsg) {
        final int msgSpacing = 10;
        final Font msgFontSize = Font.font(30);
        final Font endFontSize = Font.font(50);
        final VBox msgBox = new VBox(msgSpacing);
        finishMsg.setFont(msgFontSize);
        descriptionMsg.setFont(msgFontSize);
        endMsg.setFont(endFontSize);
        endMsg.setFill(Color.RED);
        msgBox.getChildren().addAll(finishMsg, descriptionMsg, endMsg);
        msgBox.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        StackPane centerPane = new StackPane(msgBox);
        root.setCenter(centerPane);
    }

    private void setUpNav(final Button playAgainButton) {
        final int buttonSpacing = 20;
        final int bottomHeight = 150;
        final int buttonWidth = 150;
        final Font buttonFont = Font.font(20);
        playAgainButton.setFont(buttonFont);
        playAgainButton.setMinWidth(buttonWidth);
        playAgainButton.setOnAction(actionEvent -> {
            CharacterDecision decision = new CharacterDecision();
            decision.decideCharacter(stage);
        });
        Button exitButton = new Button("Exit");
        exitButton.setFont(buttonFont);
        exitButton.setMinWidth(buttonWidth);
        exitButton.setOnAction(actionEvent -> stage.close());
        VBox bottomPane = new VBox(buttonSpacing);
        bottomPane.getChildren().addAll(playAgainButton, exitButton);
        bottomPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        bottomPane.setPrefHeight(bottomHeight);
        root.setBottom(bottomPane);
    }

    /**
     * Changes the game stage to endGame stage.
     *
     * @param gameStage the game stage which will be hided as a Stage
     * @param win the boolean to tell if the user win or lose
     * @param destination the destination of the game
     * @param time the time user spent on the game as an int
     * @throws RuntimeException the Exception to throw
     */
    public void endGame(final Stage gameStage, final boolean win, final int destination, final int time) {
        try {
            save(win, destination, time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameStage.hide();
        stage.show();
    }

    private void save(final boolean win, final int destination, final int time) throws IOException {
        String text;
        Path path = Path.of("./src/main/resources/save.txt");
        if (win) {
            text = "Won! You spent " + time + "s to get to destination " + destination + ".\n";
        } else {
            text = "Lost!\n";
        }
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Files.createFile(path.getParent().resolve("save.txt"));
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
