package sample;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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

        bar.progressProperty().bind(slider.valueProperty());
        ind.progressProperty().bind(slider.valueProperty());

        Image img = new Image("https://vignette.wikia.nocookie.net/samuraijack/images/0/0c/Aku.jpg/revision/latest?cb=20090810194231");
        ImageView iview = new ImageView(img);

        ScrollPane sp = new ScrollPane();
        sp.setContent(iview);

        TabPane pane = new TabPane();
        add(pane, 0, 3, 2, 1);

        Button b = new Button("Add Tab");
        add(b, 1, 4);
        b.setOnAction(
                (event) -> {
                    Tab t = new Tab();
                    t.setText("New Tab");
                    t.setContent(new ImageView(img));
                    pane.getTabs().add(t);
                }
        );


    }

}