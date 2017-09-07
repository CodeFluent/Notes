package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        VBox first_column = new VBox();
        first_column.setSpacing(10);
        first_column.setPadding(new Insets(15,20,10,10));

        Widget w1 = new Widget();
        first_column.getChildren().add(w1);

        VBox second_column = new VBox();
        second_column.setSpacing(10);
        second_column.setPadding(new Insets(15,20,10,10));

        Widget2 w2 = new Widget2();
        second_column.getChildren().add(w2);

        VBox third_column = new VBox();
        third_column.setSpacing(10);
        third_column.setPadding(new Insets(15,20,10,10));

        Buttons b1 = new Buttons();
        third_column.getChildren().add(b1);



        hBox.getChildren().addAll(first_column, second_column, third_column);
        primaryStage.setScene(new Scene( hBox, 680, 780));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
