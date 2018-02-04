import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunnerWindow extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        
        primaryStage.setTitle("Starting Out");
        
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}