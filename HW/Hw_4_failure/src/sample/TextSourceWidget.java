package sample;


import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Vector;



public class TextSourceWidget {

    private Vector<TextSubmissionHandle> textHandlers = new Vector<TextSubmissionHandle>();

    private SubmissionController controller;
    private SubmissionModel model;

    private TextField tf = new TextField();
    private Button submit = new Button("Submit");

    private GridPane view;

    public TextSourceWidget (SubmissionController controller, SubmissionModel model) {

        this.controller = controller;
        this.model = model;

        makeLayout();

        updateController();


//        submit.setOnAction(
//                (event) -> {
//                    String input = tf.getText();
//                    System.out.println(textHandlers.size());
//                    for (TextSubmissionHandle th: textHandlers) {
//                        th.handle(input);
//                    }
//                });

    }

    private void updateController() {
        String txt = tf.getText();

        submit.setOnAction((event) -> {
            controller.updateTxtSrc(txt);
        });
    }

    private void makeLayout() {

        view = new GridPane();
        tf.setAlignment(Pos.CENTER);
        submit.setAlignment(Pos.CENTER);

        view.add(tf, 0, 0);
        view.add(submit, 1, 0);
    }

    public Parent asParent() {
        return view;
    }

    public void addTextSubmissionHandler(TextSubmissionHandle th) {
        textHandlers.add(th);
    }
}
