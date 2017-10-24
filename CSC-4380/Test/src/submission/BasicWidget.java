package submission;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Vector;

public class BasicWidget extends GridPane {
    private Vector<BasicHandler> handlers = new Vector<BasicHandler>();

    public BasicWidget() {
        TextField tf = new TextField();
        add(tf, 0, 0);

        Button b = new Button("Submit");
        add(b, 1, 0);

        b.setOnAction(
                (event) -> {
                    String str = tf.getText();
                    System.out.println(handlers.size());
                    for (BasicHandler bh: handlers) {

                        bh.handle(str);
                    }
                });
    }

    public void addBasicHandler(BasicHandler bh) {
        // BasicHandler is the same as setOnAction(), that is you can use setOnAction with it without issues as long as you
        // declare it as the interface above in BasicHandler.java.
        handlers.add(bh);
    }

}