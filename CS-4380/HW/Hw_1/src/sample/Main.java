package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("HW 1");

        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);

        // First Column

        VBox first_column = new VBox();
        first_column.setSpacing(10);
        first_column.setPadding(new Insets(15,20,10,10));

        CheckBox cb1 = new CheckBox("First CheckBox");

        ToggleGroup tga1 = new ToggleGroup();

        RadioButton b1 = new RadioButton("1st Button");
        b1.setToggleGroup(tga1);

        RadioButton b2 = new RadioButton("2nd Button");
        b2.setToggleGroup(tga1);

        RadioButton b3 = new RadioButton("3rd Button");
        b3.setToggleGroup(tga1);

        first_column.getChildren().addAll(cb1, b1, b2, b3);

        // Second Column

        VBox second_column = new VBox();
        second_column.setSpacing(10);
        second_column.setPadding(new Insets(15,20,10,10));

        CheckBox cb2 = new CheckBox("Second CheckBox");

        RadioButton b1_2 = new RadioButton("1st Button");
        RadioButton b2_2 = new RadioButton("2nd Button");
        RadioButton b3_2 = new RadioButton("3rd Button");

        second_column.getChildren().addAll(cb2, b1_2, b2_2, b3_2);


        // Buttons

        VBox third_column = new VBox();
        third_column.setSpacing(10);
        third_column.setPadding(new Insets(15,20,10,10));

        Button submit = new Button("Submit");

        submit.setOnAction(
                (event) -> {
                    // find the checkboxes clicked
                    if(cb1.isSelected() == true) {

                    }
                    System.out.println("Clicked Submit");
                }
        );

        third_column.getChildren().add(submit);



        hBox.getChildren().addAll(first_column, second_column, third_column);
        primaryStage.setScene(new Scene( hBox, 680, 780));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
