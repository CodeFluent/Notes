package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        SubmissionModel model = new SubmissionModel();
        SubmissionController controller = new SubmissionController(model);

        // Views
        TextSourceWidget txtSrc = new TextSourceWidget(controller, model);



        Scene scene = new Scene(txtSrc.asParent(), 600, 600);
//
//        txtSrc.addTextSubmissionHandler(
//                (String input) -> {
//                    System.out.println(input);
//                }
//        );


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
