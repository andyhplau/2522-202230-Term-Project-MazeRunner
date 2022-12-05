package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class CharacterDecision {

    private static final Font BUTTON_FONT = Font.font(20);
    private static final int PREF_HEIGHT = 50;
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 650;
    private String chosenCharacter = "Pikachu";
    private StackPane titlePane;
    private StackPane optionPane;
    private StackPane navPane;
    //    private Stage driverStage;
    private final Stage stage;

    /**
     * Constructs the CharacterDecision object.
     */
    public CharacterDecision() {
        BorderPane root = new BorderPane();

        setUpTitle();
        root.setTop(titlePane);

        setUpOption();
        root.setCenter(optionPane);

        setUpNav();
        root.setBottom(navPane);

        // Setup the scene
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);

        // Setup the stage
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Maze Runner");
        stage.show();
    }

    /*
    Sets up the image buttons.
     */
    private void setUpImageButton(final RadioButton button, final String pokemon, final ToggleGroup group) {
        final int imageHeight = 150;
        final int imageWidth = 150;
        Image image = new Image(pokemon + ".png", imageWidth, imageHeight, true, true);
        button.setFont(BUTTON_FONT);
        button.setGraphic(new ImageView(image));
        button.setToggleGroup(group);
    }


    /**
     * Changes the stage to this stage.
     *
     * @param driverStage a previous stage as a Stage
     */
    public void decideCharacter(final Stage driverStage) {
        driverStage.hide();
        stage.show();
    }


    private void setUpTitle() {
        final int titleFontSize = 30;


        Text title = new Text("Choose your own Character!");
        title.setFont(Font.font(titleFontSize));
        titlePane = new StackPane(title);
        titlePane.setStyle("-fx-alignment: center;" + "-fx-background-color: lightblue;");
        titlePane.setPrefHeight(PREF_HEIGHT);
    }


    private void setUpOption() {
        final int buttonSpacing = 30;

        final ToggleGroup characters = new ToggleGroup();

        RadioButton pikachuButton = new RadioButton("Pikachu");
        pikachuButton.setSelected(true);
        pikachuButton.setOnAction(selectCharacter -> chosenCharacter = "Pikachu");
        pikachuButton.setToggleGroup(characters);

        RadioButton squirtleButton = new RadioButton("Squirtle");
        squirtleButton.setOnAction(selectCharacter -> chosenCharacter = "Squirtle");
        squirtleButton.setToggleGroup(characters);

        RadioButton meowthButton = new RadioButton("Meowth");
        meowthButton.setOnAction(selectCharacter -> chosenCharacter = "Meowth");
        meowthButton.setToggleGroup(characters);

        setUpImageButton(pikachuButton, "pikachu", characters);
        setUpImageButton(squirtleButton, "squirtle", characters);
        setUpImageButton(meowthButton, "meowth", characters);
        VBox options = new VBox(buttonSpacing);
        options.getChildren().addAll(pikachuButton, squirtleButton, meowthButton);
        options.setStyle("-fx-background-color: lightblue;" + "-fx-alignment: center");
        optionPane = new StackPane(options);
    }


    private void setUpNav() {
        Button start = new Button("Start the Game!");
        start.setFont(BUTTON_FONT);
        start.setOnAction(actionEvent -> {
            Game newGame = new Game();
            newGame.createNewGame(stage, chosenCharacter);
            newGame.startCountTime();
        });

        navPane = new StackPane(start);
        navPane.setStyle("-fx-background-color: lightblue;" + "-fx-alignment: center");
        navPane.setPrefHeight(PREF_HEIGHT);
    }
}
