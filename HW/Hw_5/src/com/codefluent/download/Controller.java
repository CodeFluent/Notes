package com.codefluent.download;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Controller {

    private Stage stage;

    @FXML
    private TextField downloadFile;

    @FXML
    private TextField saveFile;


    private Model model = new Model();

    @FXML
    private void downloadClicked() {
        // probably our interface shit.
    }

    @FXML
    private void saveClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Downloaded File");
        File file = fileChooser.showSaveDialog(this.stage);
//        model.setFilePath();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
