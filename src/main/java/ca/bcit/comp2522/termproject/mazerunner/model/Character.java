package ca.bcit.comp2522.termproject.mazerunner.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Character extends Pane {

    // Character Configuration
    ImageView imageView;

    int offsetX = 0;
    int offsetY = 0;
    int width = 32;
    int height = 32;

    public Character(ImageView imageView) {
        this.imageView = imageView;

        getChildren().addAll(imageView);
    }


}
