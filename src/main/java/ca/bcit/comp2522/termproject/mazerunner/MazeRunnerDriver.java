package ca.bcit.comp2522.termproject.mazerunner;

import ca.bcit.comp2522.termproject.mazerunner.model.History;
import ca.bcit.comp2522.termproject.mazerunner.view.CharacterDecision;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;

/**
 * Starts as the landing page.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class MazeRunnerDriver extends Application {
    private static final Font TEXT_FONT_SIZE = Font.font(30);
    private static final Font BUTTON_FONT_SIZE = Font.font(20);
    private static MediaPlayer introMusic;
    private static MediaPlayer gameMusic;
    private static MediaPlayer gameOver;
    private static MediaPlayer gameWin;

    /**
     * Starts the program.
     *
     * @param stage a stage as a Stage
     */
    @Override
    public void start(final Stage stage) {
        final int buttonWidth = 150;
        final int spacing = 50;
        final int screenWidth = 600;
        final int screenHeight = 650;

        Text welcome = new Text("Welcome to Maze Runner!");
        welcome.setFont(TEXT_FONT_SIZE);
        Text instruction = new Text("Please select 1 of below options:");
        instruction.setFont(TEXT_FONT_SIZE);
        Button play = new Button("Play");
        play.setFont(BUTTON_FONT_SIZE);
        play.setMinWidth(buttonWidth);
        play.setOnAction(actionEvent -> {
            CharacterDecision decision = new CharacterDecision();
            decision.decideCharacter(stage);
        });

        Button pastHistory = new Button("Past History");
        pastHistory.setFont(BUTTON_FONT_SIZE);
        pastHistory.setMinWidth(buttonWidth);
        pastHistory.setOnAction(actionEvent -> {
            History history = new History();
            history.readRecord(stage);
        });

        Button exit = new Button("Exit");
        exit.setFont(BUTTON_FONT_SIZE);
        exit.setMinWidth(buttonWidth);
        exit.setOnAction(actionEvent -> {
            stage.close();
        });

        VBox vBox = new VBox(spacing);
        vBox.getChildren().addAll(welcome, instruction, play, pastHistory, exit);
        vBox.setStyle("-fx-background-color: lightblue;" + "-fx-alignment: center");

        Scene scene = new Scene(vBox, screenWidth, screenHeight);
        introMusicOn();
        stage.setScene(scene);
        stage.setTitle("Maze Runner");
        stage.show();
    }

    /**
     * Starts the intro music.
     */
    public static void introMusicOn() {
        String title = "src/main/resources/introMusic.mp3";
        Media song = new Media(Paths.get(title).toUri().toString());
        introMusic = new MediaPlayer(song);
        introMusic.play();
    }

    /**
     * Stops the intro music.
     */
    public static void introMusicOff() {
        introMusic.stop();
    }

    /**
     * Starts the game music.
     */
    public static void gameMusicOn() {
        String title = "src/main/resources/gameMusic.mp3";
        Media song = new Media(Paths.get(title).toUri().toString());
        gameMusic = new MediaPlayer(song);
        gameMusic.play();
    }
    /**
     * Stops the intro music.
     */
    public static void gameMusicOff() {
        gameMusic.stop();
    }

    /**
     * Starts the game over music.
     */
    public static void gameOverMusicOn() {
        String title = "src/main/resources/gameOverMusic.mp3";
        Media song = new Media(Paths.get(title).toUri().toString());
        gameOver = new MediaPlayer(song);
        gameOver.play();
    }
    /**
     * Stops the game over music.
     */
    public static void gameOverMusicOff() {
        gameOver.stop();
    }

    /**
     * Starts the game win music.
     */
    public static void gameWinMusicOn() {
        String title = "src/main/resources/winMusic.mp3";
        Media song = new Media(Paths.get(title).toUri().toString());
        gameWin = new MediaPlayer(song);
        gameWin.play();
    }
    /**
     * Stops the game win music.
     */
    public static void gameWinMusicOff() {
        gameWin.stop();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
