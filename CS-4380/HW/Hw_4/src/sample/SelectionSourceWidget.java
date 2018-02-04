package sample;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.util.Vector;

public class SelectionSourceWidget extends GridPane {

    private Vector<SelectionSourceHandle> selectionHandlers = new Vector<SelectionSourceHandle>();

    private ToggleGroup tga = new ToggleGroup();

    private RadioButton r1 = new RadioButton("R1");
    private RadioButton r2 = new RadioButton("R2");
    private RadioButton r3 = new RadioButton("R3");
    private RadioButton r4 = new RadioButton("R4");

    private Button submit = new Button("Submit");

    public SelectionSourceWidget () {

        makeLayout();

        submit.setOnAction(
                (event) -> {
                    RadioButton selected = (RadioButton) tga.getSelectedToggle();
                    String radio = selected.getText();
                    for (SelectionSourceHandle sh: selectionHandlers) {
                        sh.handleSelectionSubmission(radio);
                    }
                });

    }

    private void makeLayout() {
        r1.setToggleGroup(tga);
        r2.setToggleGroup(tga);
        r3.setToggleGroup(tga);
        r4.setToggleGroup(tga);

        add(r1, 0, 0);
        add(r2, 0, 1);
        add(r3, 1, 0);
        add(r4, 1, 1);

        add(submit, 2, 1);


    }

    public void addSelectionSourceHandler(SelectionSourceHandle sh) {
        selectionHandlers.add(sh);
    }
}
