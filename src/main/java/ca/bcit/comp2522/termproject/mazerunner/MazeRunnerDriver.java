package ca.bcit.comp2522.termproject.mazerunner;

import ca.bcit.comp2522.termproject.mazerunner.view.CharacterDecision;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javafx.scene.media.Media;

/**
 * Starts as the landing page.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class MazeRunnerDriver extends Application {
    private static final Font TEXT_FONT_SIZE = Font.font(30);
    private static final Font BUTTON_FONT_SIZE = Font.font(20);

    /**
     * Starts the program.
     *
     * @param stage a stage as an Stage
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

        Button exit = new Button("Exit");
        exit.setFont(BUTTON_FONT_SIZE);
        exit.setMinWidth(buttonWidth);

        VBox vBox = new VBox(spacing);
        vBox.getChildren().addAll(welcome, instruction, play, pastHistory, exit);
        vBox.setStyle("-fx-background-color: lightblue;" + "-fx-alignment: center");

        Scene scene = new Scene(vBox, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("Maze Runner");
        stage.show();
    }

//    Media mediaPlayer;
//    public void music() {
//        String title = "Run-Amok.mp3";
//        Media h = new  Media(Paths.get(title).toUri().toString());
//        mediaPlayer = new MediaPlayer(h);
//        mediaPlayer.play();
//    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
