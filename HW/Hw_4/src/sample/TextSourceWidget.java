package sample;


import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Vector;



public class TextSourceWidget extends GridPane {

    private Vector<TextSubmissionHandle> textHandlers = new Vector<TextSubmissionHandle>();

    private TextField tf = new TextField();
    private Button submit = new Button("Submit");

    public TextSourceWidget () {


        makeLayout();

        submit.setOnAction(
                (event) -> {
                    String input = tf.getText();
                    for (TextSubmissionHandle th: textHandlers) {
                        th.handleTextSubmission(input);
                    }
                });

    }

    private void makeLayout() {

        tf.setAlignment(Pos.CENTER);
        submit.setAlignment(Pos.CENTER);

        add(tf, 0, 0);
        add(submit, 1, 0);
    }

    public void addTextSubmissionHandler(TextSubmissionHandle th) {
        textHandlers.add(th);
    }
}
