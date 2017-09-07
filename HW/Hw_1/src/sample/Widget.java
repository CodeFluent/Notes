package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

class Widget extends GridPane {

    public Widget() {

        CheckBox cb1 = new CheckBox("First CheckBox");
        add(cb1, 0, 0);

        ToggleGroup tga1 = new ToggleGroup();

        RadioButton b1 = new RadioButton("1st Button");
        add(b1, 1, 1);
        b1.setToggleGroup(tga1);

        RadioButton b2 = new RadioButton("2nd Button");
        add(b2, 1, 2);
        b2.setToggleGroup(tga1);

        RadioButton b3 = new RadioButton("3rd Button");
        add(b3, 1, 3);
        b3.setToggleGroup(tga1);

//        b3.setSelected(true);

//        String selected = (String) tga1.getSelectedToggle().getUserData();
//
//        System.out.println(selected);


    }

}

class Widget2 extends GridPane {

    public Widget2 () {
        CheckBox cb2 = new CheckBox("Second CheckBox");
        add(cb2, 0, 0);

        RadioButton b1 = new RadioButton("1st Button");
        RadioButton b2 = new RadioButton("2nd Button");
        RadioButton b3 = new RadioButton("3rd Button");
    }

}

class Buttons extends GridPane {

    public Buttons () {

        Button submit = new Button("Submit");
        add(submit, 0, 0);

        submit.setOnAction(
                (event) -> {
                    // find the checkboxes clicked

                    System.out.println("Clicked Submit");
                }
        );

    }
}
