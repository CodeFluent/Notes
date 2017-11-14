package com.codefluent.download;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;


public class Controller {

    private Stage stage;
    private Model model = new Model();
    private Vector<DownloadHandle> downloadHandlers = new Vector<DownloadHandle>();

    @FXML
    private TextField downloadFile;

    @FXML
    private TextField saveFile;



    @FXML
    private void downloadClicked() {
        String input = downloadFile.getText();
        model.startDownload(input);
        for(DownloadHandle dh: downloadHandlers) {
            dh.handleDownload(input);
        }

    }

    @FXML
    private void saveClicked() {

        // I used a directory chooser instead of a file chooser.
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Save Downloaded File");
        File selectedDir = directoryChooser.showDialog(this.stage);
//        System.out.println("File path: " + selectedDir.getPath());
        model.setFilePath(selectedDir.getPath());
        this.saveFile.setText(selectedDir.getPath());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addDownloadHandler(DownloadHandle dh) {
        downloadHandlers.add(dh);
    }
}
