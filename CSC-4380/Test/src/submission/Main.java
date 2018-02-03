package submission;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BasicWidget root = new BasicWidget();

        root.addBasicHandler(
                (String str) -> {
                    System.out.println(str);
                }
        );


        primaryStage.setTitle("Basic Interface Event");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
