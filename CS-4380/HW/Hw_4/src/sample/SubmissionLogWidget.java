package sample;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;


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
        setHgrow(tf, Priority.ALWAYS);
        tf.setPadding(new Insets(10, 10, 10, 10));
        add(tf, 0, 0);
    }

}
