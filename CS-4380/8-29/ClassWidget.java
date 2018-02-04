import java.util.Observable;

import javafx.*;
import javafx.scene.control.ComboBox;


class ClassWidget extends GridPane {

    public ClassWidget() {
        CheckBox cb = new CheckBox("Check Me!");
        add(cb, 0 , 0);
        cb.selectedProperty().set(true);

        ToggleGroup tga = new ToggleGroup();

        RadioButton r1 = new RadioButton("r1");
        add(r1, 0 , 1);
        ra1.setToggleGroup(tga);

        RadioButton r2 = new RadioButton("r2");
        add(r2, 0, 2);
        r2.setToggleGroup(tga);

        RadioButton rb1 = new RadioButton("rb1");
        add(rb1, 1, 1);


        // old_val and new_val are actually type RadioButton object
        tga.selectedToggleProperty().addListener(
            (observable, old_val, new_val) -> {
                System.out.println("Changed");  

                // r1 is the class variable that the compiler
                // sees that it can be final so it can be used in 
                // the scope here to compare to new_val here.

                if (new_val == r1) {
                    System.out.println("r1");
                } else {
                    System.out.println("r2");
                }
            }
        );

        // Always remebmer to include <String> type parameter.
        ComboBox<String> combo = new ComboBox<String>();
        combo.getItems().addAll("One", "Two", "Three");
        add(combo, 0 , 3);

        // old_val and new_val here are actually strings,
        // since combobox are strings.
        combo.valueProperty().addListener(
            (observable, old_val, new_val) -> {
                System.out.println(new_val);
            }
            
        );
    }

}

