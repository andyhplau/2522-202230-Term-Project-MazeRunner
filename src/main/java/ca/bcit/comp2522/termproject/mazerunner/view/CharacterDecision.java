package ca.bcit.comp2522.termproject.mazerunner.view;

import ca.bcit.comp2522.termproject.mazerunner.model.Character;
import ca.bcit.comp2522.termproject.mazerunner.view.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents the page for user to select their own character.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class CharacterDecision extends Application {

    private static final Font BUTTON_FONT = Font.font(20);
    private String chosenCharacter = "Pikachu";

    /*
    Sets up the image buttons.
     */
    private void setUpImageButton(final RadioButton button, final String pokemon, final ToggleGroup group) {
        final int height = 150;
        final int width = 150;
        Image image = new Image(pokemon + ".png", width, height, true, true);
        button.setFont(BUTTON_FONT);
        button.setGraphic(new ImageView(image));
        button.setToggleGroup(group);
    }

    /**
     * Creates the page for character decision.
     *
     * @param stage a Stage
     */
    @Override
    public void start(final Stage stage) {
        // declare the variables for size, spacing, width, height
        final int titleFontSize = 30;
        final int buttonSpacing = 30;
        final int screenWidth = 600;
        final int screenHeight = 650;
        final int prefHeight = 50;
        final double anchorSize = 30.0;

        // Construct the title pane
        Text title = new Text("Choose your own Character!");
        title.setFont(Font.font(titleFontSize));
        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        titlePane.setPrefHeight(prefHeight);

        // Construct the option pane
        final ToggleGroup characters = new ToggleGroup();

        RadioButton pikachuButton = new RadioButton("Pikachu");
        pikachuButton.setSelected(true);
        pikachuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent selectCharacter) {
                chosenCharacter = "Pikachu";
            }
        });
        pikachuButton.setToggleGroup(characters);

        RadioButton squirtleButton = new RadioButton("Squirtle");
        squirtleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent selectCharacter) {
                chosenCharacter = "Squirtle";
            }
        });
        squirtleButton.setToggleGroup(characters);

        RadioButton meowthButton = new RadioButton("Meowth");
        meowthButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent selectCharacter) {
                chosenCharacter = "Meowth";
            }
        });
        meowthButton.setToggleGroup(characters);

        RadioButton userPictureButton;
        setUpImageButton(pikachuButton, "pikachu", characters);
        setUpImageButton(squirtleButton, "squirtle", characters);
        setUpImageButton(meowthButton, "meowth", characters);
        VBox options = new VBox(buttonSpacing);
        options.getChildren().addAll(pikachuButton, squirtleButton, meowthButton);
        options.setStyle("-fx-background-color: lightblue;" + "-fx-alignment: center");
        StackPane optionPane = new StackPane(options);

        // Construct the nav pane
        Button back = new Button("Go Back!");
        back.setFont(BUTTON_FONT);
        Button start = new Button("Start the Game!");
        start.setFont(BUTTON_FONT);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Game newGame = new Game();
                newGame.createNewGame(stage, chosenCharacter);
                newGame.startCountTime();
            }
        });

        AnchorPane navPane = new AnchorPane(back, start);
        navPane.setStyle("-fx-background-color: lightblue;");
        navPane.setPrefHeight(prefHeight);
        AnchorPane.setBottomAnchor(back, anchorSize);
        AnchorPane.setLeftAnchor(back, anchorSize);
        AnchorPane.setBottomAnchor(start, anchorSize);
        AnchorPane.setRightAnchor(start, anchorSize);

        // Construct the border pane - root
        BorderPane root = new BorderPane();
        root.setTop(titlePane);
        root.setCenter(optionPane);
        root.setBottom(navPane);

        // Setup the scene
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Setup the stage
        stage.setScene(scene);
        stage.setTitle("Maze Runner");
        stage.show();
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
