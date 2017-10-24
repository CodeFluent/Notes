package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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
        submit.setAlignment(Pos.CENTER);
        add(xValue, 1, 0);
        add(yValue, 2, 0);
        add(zValue, 3, 0);

        add(submit, 4, 0);
    }

    public void addPointSourceHandler(PointSourceWidgetHandle ph) {
        pointSourceHandlers.add(ph);
    }
}
