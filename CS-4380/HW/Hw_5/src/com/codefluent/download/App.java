package com.codefluent.download;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent root = (Parent) loader.load();

        Controller controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
