package sample;

import com.sun.javafx.scene.text.TextLine;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {

    // needs to be final in the lambda, so make it global to all methods.
    int correctCounter = 0;
    int incorrectCounter = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("HW_2 Guessing Widget");

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHalignment(HPos.LEFT);
        c1.setHgrow(Priority.NEVER);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHgrow(Priority.ALWAYS);


        root.getColumnConstraints().addAll(c1, c2);


//        root.setGridLinesVisible(true); // Nice debug property

        ToggleGroup tga1 = new ToggleGroup();

        RadioButton r1 = new RadioButton("R1");
        RadioButton r2 = new RadioButton("R2");
        RadioButton r3 = new RadioButton("R3");
        RadioButton r4 = new RadioButton("R4");

        r1.setToggleGroup(tga1);
        r2.setToggleGroup(tga1);
        r3.setToggleGroup(tga1);
        r4.setToggleGroup(tga1);

        root.add(r1, 0, 0);
        root.add(r2, 0, 1);
        root.add(r3, 1, 0);
        root.add(r4, 1, 1);

        Button guess = new Button("Guess");
        root.add(guess, 2, 2);

        TextField score = new TextField();
        score.setEditable(false);
        score.setMinWidth(200);
        score.setPrefWidth(300);
        root.add(score, 2, 3);



        guess.setOnAction(
                (event) -> {

                    if (tga1.getSelectedToggle() == null) {
                        score.setText("Yo dawg pick a button.");
                    } else {
                        game(score);
                    }

                }
        );


        primaryStage.setScene(new Scene(root, 800, 875));
        primaryStage.show();
    }

    private void game(TextField result) {

        double rand = Math.random() * 1.0;

        if (rand < .25) {
            increaseCorrectCounter();
            result.setText("Correct Guesses: " + correctCounter + " InCorrect Guesses: " + incorrectCounter);
        } else {
            increaseIncorrectCounter();
            result.setText("Correct Guesses: " + correctCounter + " InCorrect Guesses: " + incorrectCounter);
        }
    }

    private void increaseCorrectCounter() {
        correctCounter++;
    }

    private void increaseIncorrectCounter() {
        incorrectCounter++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
