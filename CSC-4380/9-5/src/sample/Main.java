package sample;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("9-5");

        GridPane root = new GridPane();
        BarWidget bw = new BarWidget();

        root.add(bw, 0, 0);


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
