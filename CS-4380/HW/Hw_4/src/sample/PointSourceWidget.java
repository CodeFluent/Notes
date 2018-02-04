package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Vector;

public class PointSourceWidget extends GridPane {
    private Vector<PointSourceWidgetHandle> pointSourceHandlers= new Vector<PointSourceWidgetHandle>();

    private Slider xValue = new Slider(0, 1, 1);
    private Slider yValue = new Slider(0, 1, 1);
    private Slider zValue = new Slider(0, 1, 1);

    private Button submit = new Button("Submit");

    public PointSourceWidget() {
        makeLayout();

        submit.setOnAction(
                (event) -> {
                    double x = xValue.getValue();
                    double y = yValue.getValue();
                    double z = zValue.getValue();
                    for (PointSourceWidgetHandle ph: pointSourceHandlers) {
                        ph.handlePointSourceSubmission(x, y, z);
                    }
        });
    }

    private void makeLayout() {

        HBox hold = new HBox();

        hold.getChildren().addAll(xValue, yValue, zValue, submit);

        add(hold, 0, 0);

        this.setPadding(new Insets(10, 20, 10, 20));


    }

    public void addPointSourceHandler(PointSourceWidgetHandle ph) {
        pointSourceHandlers.add(ph);
    }
}
