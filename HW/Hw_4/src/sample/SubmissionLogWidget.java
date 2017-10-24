package sample;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;


public class SubmissionLogWidget extends GridPane {

    private TextArea tf = new TextArea();

    public SubmissionLogWidget() {

        makeLayout();
    }

    public void logSubmission(String input) {
        tf.appendText(input + "\n");
    }

    private void makeLayout() {

        tf.setEditable(false);
        add(tf, 0, 0);
    }

}
