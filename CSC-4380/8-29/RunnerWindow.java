import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BasicApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        BasicWidget bw = new BasicWidget();

        primaryStage.setTitle("8-29 Work");

        primaryStage.setScene(new Scene(bw, 400, 400));
        primaryStage.show();
    }
}