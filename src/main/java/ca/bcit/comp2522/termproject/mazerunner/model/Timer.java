package ca.bcit.comp2522.termproject.mazerunner.model;

import ca.bcit.comp2522.termproject.mazerunner.view.GameOver;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

/**
 * Represents a timer for a game.
 *
 * @author Andy Lau
 * @version 202230
 */
public class Timer {

    private static final Font TIMER_FONT_SIZE = Font.font(30);
    private int time;
    private Stage gameStage;
    private final Text timeText;
    private final Timeline timeline;
    private final StackPane timerPane;

    /**
     * Constructs a Timer object.
     *
     * @param timeLimit an int that represents the time limit of the game
     */
    public Timer(final int timeLimit) {
        this.time = timeLimit;
        this.timeText = new Text();
        this.timeline = new Timeline();
        this.timerPane = new StackPane(timeText);
        setUpPane();
    }

    /**
     * Returns the pane of the timer.
     *
     * @return timerPane as a StackPane
     */
    public StackPane getTimerPane() {
        return timerPane;
    }

    /**
     * Returns the current time left in the game.
     *
     * @return time as an int
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the time to a new value.
     *
     * @param time an int represents new time limit to set
     */
    public void setTime(final int time) {
        this.time = time;
    }

    /**
     * Sets the gameStage from the Game Class.
     *
     * @param gameStage the gameStage from Game class as a Stage
     */
    public void setStage(final Stage gameStage) {
        this.gameStage = gameStage;
    }

    /**
     * Sets up the TimerPane.
     */
    public void setUpPane() {
        timeText.setText("Time Left: " + time + " sec");
        timeText.setFont(TIMER_FONT_SIZE);
        timerPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        timerPane.setPrefHeight(50);
    }

    /**
     * Starts counting the time of the game.
     */
    public void startCount() {
        Decrement decrement = new Decrement();
        KeyFrame frame = new KeyFrame(Duration.seconds(1), decrement);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    /*
    Handles the decrement of time.
     */
    class Decrement implements EventHandler<ActionEvent> {

        @Override
        public void handle(final ActionEvent actionEvent) {
            time--;
            timeText.setText("Time Left: " + time + " sec");
            if (time <= 0) {
                timeline.stop();
                GameOver gameOver = new GameOver();
                gameOver.endGame(gameStage);
            }
        }
    }

    /**
     * Compare an object with a Timer object.
     *
     * @param o an object
     * @return true if they are the same, else false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Timer timer = (Timer) o;
        return time == timer.time && Objects.equals(timeText, timer.timeText)
                && Objects.equals(timeline, timer.timeline) && Objects.equals(timerPane, timer.timerPane);
    }

    /**
     * Returns a hashCode for this instance of the Timer class.
     *
     * @return HashCode as an int
     */
    @Override
    public int hashCode() {
        final int prime = 17;
        final int hashValue = 37;
        int result = prime;
        result = hashValue * result + time;
        result = hashValue * result + Objects.hashCode(timeText);
        result = hashValue * result + Objects.hashCode(timeline);
        result = hashValue * result + Objects.hashCode(timerPane);
        return result;
    }

    /**
     * Returns a String representation of this Timer object.
     *
     * @return description of this Timer object
     */
    @Override
    public String toString() {
        return "Timer{" + "time=" + time + ", timeText=" + timeText
                + ", timeline=" + timeline + ", timerPane=" + timerPane + '}';
    }
}
