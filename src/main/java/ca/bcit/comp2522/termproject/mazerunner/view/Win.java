package ca.bcit.comp2522.termproject.mazerunner.view;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Represents the page when user wins the game.
 *
 * @author Andy & Soo
 * @version 202230
 */
public class Win extends EndGame {
    /**
     * Constructs the GameOver object.
     *
     * @param time the time the character took to win the game as an int
     */
    public Win(final int time) {
        super(
                new Text("Congratulations!"),
                new Text("Your character have successfully\nescaped from the maze!\n\nThe time you used is:"),
                new Text(time + "s"),
                new Button("Play Again!")
        );
    }
}
