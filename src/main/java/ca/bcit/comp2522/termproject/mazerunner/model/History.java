package ca.bcit.comp2522.termproject.mazerunner.model;

import ca.bcit.comp2522.termproject.mazerunner.view.CharacterDecision;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a page to show to history of game plays.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class History {
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 650;
    private final BorderPane root;
    private final Stage stage;

    /**
     * Constructs the History object.
     */
    public History() {
        root = new BorderPane();
        setUpTitle();
        setUpCenter();
        setUpNav();

        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        stage = new Stage();
        stage.setTitle("Maze Runner");
        stage.setScene(scene);
    }

    /**
     * Changes the stage to history stage.
     *
     * @param landingStage landing stage as a Stage
     */
    public void readRecord(final Stage landingStage) {
        landingStage.hide();
        stage.show();
    }

    private void setUpTitle() {
        final Font titleFontSize = Font.font(30);
        final int titleHeight = 50;
        Text title = new Text("Below is the record of your past attempts:");
        title.setFont(titleFontSize);
        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        titlePane.setPrefHeight(titleHeight);
        root.setTop(titlePane);
    }

    private void setUpCenter() {
        final Font msgFontSize = Font.font(20);
        Text record = new Text(readSave());
        record.setFont(msgFontSize);
        record.setFont(msgFontSize);
        StackPane centerPane = new StackPane(record);
        centerPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        root.setCenter(centerPane);
    }

    private void setUpNav() {
        final int bottomHeight = 100;
        final Font buttonFont = Font.font(20);
        Button startGame = new Button("Start the game!");
        startGame.setFont(buttonFont);
        startGame.setOnAction(actionEvent -> {
            CharacterDecision decision = new CharacterDecision();
            decision.decideCharacter(stage);
        });
        StackPane bottomPane = new StackPane(startGame);
        bottomPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        bottomPane.setPrefHeight(bottomHeight);
        root.setBottom(bottomPane);
    }

    private String readSave() {
        Path path = Path.of("./src/main/resources/save.txt");
        String fileContents;
        try {
            fileContents = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(fileContents);
        return fileContents;
    }
}
