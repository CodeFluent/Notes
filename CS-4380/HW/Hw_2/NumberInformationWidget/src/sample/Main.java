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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("HW 2");

        VBox vBox = new VBox(50);


        HBox hBox1 = new HBox(50);
        hBox1.setAlignment(Pos.BASELINE_CENTER);
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(30,20,10,10));

        HBox hBox2 = new HBox(50);
        hBox2.setAlignment(Pos.BASELINE_CENTER);
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(30,20,10,10));


        ObservableList <String> options = FXCollections.observableArrayList("Even", "Prime");

        // First Row

        TextField equation = new TextField();

        ComboBox<String> optionBox = new ComboBox<String>();
        optionBox.setItems(options);

        Button run = new Button("Run");

        hBox1.getChildren().addAll(equation, optionBox, run);
        hBox1.setHgrow(equation, Priority.ALWAYS);


        // Second Row

        TextArea output = new TextArea();
        output.setEditable(false);

        hBox2.getChildren().addAll(output);
        hBox2.setHgrow(output, Priority.ALWAYS);



        run.setOnAction(event -> {

            String regex = "[0-9]+";
            String input = equation.getText();


            // if string input is not a number, warn the user.
            if ((!(input.matches(regex)) && (optionBox.getValue() != null))) {
                output.appendText(input + " is not a valid number, please enter a " +
                        "valid number. \n");
            } else if (optionBox.getValue() == null) {
                // user notice for combobox issue.
                // (ComboBox with observable list appends empty to options list)
                output.appendText("Please pick Even or Prime from the ComboBox. \n");
            } else {

                Integer process = Integer.parseInt(input);

                if (optionBox.getValue() == "Even") {
                    isEven(process, output);
                }

                if (optionBox.getValue() == "Prime") {
                    if(isPrime(process) == true) {
                        output.appendText(process + " is PRIME. \n");
                    } else {
                        output.appendText(process + " is NOT PRIME. \n");
                    }
                }

            }


        });

        vBox.getChildren().addAll(hBox1, hBox2);


        primaryStage.setScene(new Scene(vBox, 680, 780));
        primaryStage.show();


    }

    public void isEven(Integer process, TextArea output) {
        if (process % 2 == 0) {
            output.appendText(process + " is Even.");
        } else {
            output.appendText(process + " is Odd.");
        }
    }

    public boolean isPrime(Integer process) {

        // if less than 1 then not prime
        if (process < 1) {
            return false;
        }

        // if 1 or 2, then prime.
        if (process < 3) {
            return true;
        }

        // if number is divisible by process / 2, then it is not prime.
        for(int i = 2; 2 * i <= process; i++) {
            if (process % i == 0) {
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {
        launch(args);
    }
}
