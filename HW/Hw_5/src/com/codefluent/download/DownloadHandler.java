package com.codefluent.download;

import javafx.event.ActionEvent;

public class DownloadHandler {

    @FunctionalInterface
    public interface DownloadHandle {
        void handleDownload(ActionEvent event);
    }
}
