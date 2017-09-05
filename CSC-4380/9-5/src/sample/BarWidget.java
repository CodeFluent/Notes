package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.Priority;

class BarWidget extends GridPane {

    public BarWidget() {
        ProgressBar bar = new ProgressBar();
        add(bar, 0, 0, 2, 1);
        setHgrow(bar, Priority.ALWAYS);

        ProgressIndicator ind = new ProgressIndicator();
        add(ind, 2, 0);

        Slider slider = new Slider();
        add(slider, 0, 1, 2, 1);
    }

}