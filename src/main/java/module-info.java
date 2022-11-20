module ca.bcit.comp2522.termproject.mazerunner {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;


    opens ca.bcit.comp2522.termproject.mazerunner to javafx.fxml;
    exports ca.bcit.comp2522.termproject.mazerunner;
    exports ca.bcit.comp2522.termproject.mazerunner.model;
    exports ca.bcit.comp2522.termproject.mazerunner.view;
}