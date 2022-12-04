package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Win extends EndGame{
    /**
     * Constructs the GameOver object.
     *
     * @param time the time the character took to win the game as an int
     */
    public Win(final int time) {
        super(
                new Text("Congratulations!"),
                new Text("Your character have successfully escaped from the maze!\nThe time you used is:"),
                new Text(Integer.toString(time) + "s"),
                new Button("Play Again!")
        );
    }
//    private static final int APP_WIDTH = 600;
//    private static final int APP_HEIGHT = 650;
//    private final BorderPane root;
//    private final Stage stage;

//    private void setUpCenter(final int time) {
//        final int msgSpacing = 10;
//        final Font msgFontSize = Font.font(30);
//        final Font timeFontSize = Font.font(50);
//        final VBox msgBox = new VBox(msgSpacing);
//        Text congratMsg = new Text("Congratulations!");
//        congratMsg.setFont(msgFontSize);
//        Text descriptionMsg = new Text("Your character have successfully escaped from the maze!\n"
//                + "The time you used is:");
//        descriptionMsg.setFont(msgFontSize);
//        Text timeMsg = new Text(Integer.toString(time) + "s");
//        timeMsg.setFont(timeFontSize);
//        timeMsg.setFill(Color.RED);
//        msgBox.getChildren().addAll(congratMsg, descriptionMsg, timeMsg);
//        msgBox.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
//        StackPane centerPane = new StackPane(msgBox);
//        root.setCenter(centerPane);
//    }
//
//    private void setUpNav() {
//        final int bottomHeight = 100;
//        final Font buttonFont = Font.font(20);
//        Button playAgainButton = new Button("Play Again!");
//        playAgainButton.setFont(buttonFont);
//        playAgainButton.setOnAction(actionEvent -> {
//            CharacterDecision decision = new CharacterDecision();
//            decision.decideCharacter(stage);
//        });
//        StackPane bottomPane = new StackPane(playAgainButton);
//        bottomPane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
//        bottomPane.setPrefHeight(bottomHeight);
//        root.setBottom(bottomPane);
//    }
}
