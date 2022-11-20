package ca.bcit.comp2522.termproject.mazerunner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Represents a timer for a game.
 *
 * @author Andy Lau
 * @version 202230
 */
public class Timer extends Application {

    private static final Integer TIME_LIMIT = 5;
    private Integer time = TIME_LIMIT;
    private final Text timeText = new Text();
    private final Timeline timeline = new Timeline();

    /**
     * Represents a timer.
     *
     * @param stage a Stage
     */
    @Override
    public void start(final Stage stage) {
        // declare the variables for size, spacing, width, height
        final Font timeFontSize = Font.font(50);
        final int screenWidth = 1920;
        final int screenHeight = 1080;

        // Construct the timePane
        timeText.setText("Time Left: " + time.toString() + " sec");
        timeText.setFont(timeFontSize);
        StackPane timePane = new StackPane(timeText);
        timePane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        countDown();

        // Construct the border pane - root
        BorderPane root = new BorderPane();
        root.setTop(timePane);

        // Set up the scene
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Set up the stage
        stage.setScene(scene);
        stage.setTitle("Maze Runner");
        stage.show();
    }

    private void countDown() {
        Decrement decrement = new Decrement();
        KeyFrame frame = new KeyFrame(Duration.seconds(1), decrement);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    class Decrement implements EventHandler<ActionEvent> {

        @Override
        public void handle(final ActionEvent actionEvent) {
            time--;
            timeText.setText("Time Left: " + time + " sec");
            if (time <= 0) {
                timeline.stop();
                // end the game and the player lose
            }
        }
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
