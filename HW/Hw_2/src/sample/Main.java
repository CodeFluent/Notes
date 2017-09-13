package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("HW 2");

        HBox hBox1 = new HBox(50);
        hBox1.setAlignment(Pos.BASELINE_CENTER);
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(30,20,10,10));

        HBox hBox2 = new HBox(50);

        ObservableList <String> options = FXCollections.observableArrayList("Even", "Prime");

        // First Row

        TextField equation = new TextField();

        ComboBox<String> optionBox = new ComboBox<String>();
        optionBox.setItems(options);

        Button run = new Button("Run");

        hBox1.getChildren().addAll(equation, optionBox, run);


        primaryStage.setScene(new Scene(hBox1, 680, 780));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
