package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Represents a game over page when user lose.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class GameOver extends EndGame {
    /**
     * Constructs the GameOver object.
     */
    public GameOver() {
        super(
                new Text("Time is up!"),
                new Text("Your character cannot escape in time!\nIt will trap in this maze forever..."),
                new Text("Game Over!"),
                new Button("Start Again!")
        );
    }
}
