module ca.bcit.comp2522.termproject.mazerunner {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.mazerunner to javafx.fxml;
    exports ca.bcit.comp2522.termproject.mazerunner;
}