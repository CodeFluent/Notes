package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox root = new VBox();

        SubmissionLogWidget subLog = new SubmissionLogWidget();
        TextSourceWidget txtSrc = new TextSourceWidget();
        PointSourceWidget ptSrc = new PointSourceWidget();

        ptSrc.addPointSourceHandler(
                (double x, double y, double z) -> {
                    String xValue = Double.toString(x);
                    String yValue = Double.toString(y);
                    String zValue = Double.toString(z);

                    String total = "( " + xValue + ", " + yValue + ", " + zValue + " )";
                    subLog.logSubmission(total);
                }
        );

        txtSrc.addTextSubmissionHandler(
                (String input) -> {
                    System.out.println(input);
                    subLog.logSubmission(input);
                }
        );




        root.getChildren().addAll(txtSrc, ptSrc, subLog);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Homework 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
