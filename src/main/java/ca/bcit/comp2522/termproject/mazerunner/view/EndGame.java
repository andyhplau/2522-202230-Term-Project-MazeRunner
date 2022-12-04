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

/**
 * Represents a page when the game ends.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class EndGame {
    /**
     * Default app screen width.
     */
    private static final int APP_WIDTH = 600;
    /**
     * Default app screen height.
     */
    private static final int APP_HEIGHT = 650;
    /**
     * The Pane to pass to scene the hold all the panes.
     */
    private final BorderPane root;
    /**
     * The stage to project.
     */
    private final Stage stage;

    /**
     * Constructs the EndGame object.
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
        final int bottomHeight = 100;
        final Font buttonFont = Font.font(20);
        playAgainButton.setFont(buttonFont);
        playAgainButton.setOnAction(actionEvent -> {
            CharacterDecision decision = new CharacterDecision();
            decision.decideCharacter(stage);
        });
        StackPane bottomPane = new StackPane(playAgainButton);
        bottomPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        bottomPane.setPrefHeight(bottomHeight);
        root.setBottom(bottomPane);
    }

    /**
     * Changes the game stage to endGame stage.
     *
     * @param gameStage the game stage which will be hided as a Stage
     */
    public void endGame(final Stage gameStage) {
        gameStage.hide();
        stage.show();
    }
}
