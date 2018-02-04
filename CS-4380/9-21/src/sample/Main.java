package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("9-21");

        BorderPane root = new BorderPane();

        MenuBar bar = new MenuBar();
        Menu fileMenu = new Menu("File");

        MenuItem openItem = new MenuItem("OPEN FILE");

        fileMenu.getItems().addAll(openItem);

        SeparatorMenuItem sep = new SeparatorMenuItem();

        Menu recents = new Menu("Recent Items");
        MenuItem lies = new MenuItem("LIES");

        recents.getItems().addAll(lies);

        bar.getMenus().addAll(fileMenu);


        root.getChildren().addAll(bar);
        root.setTop(bar);


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
