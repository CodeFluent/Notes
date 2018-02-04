package com.codefluent.download;

@FunctionalInterface
public interface DownloadHandle {
    void handleDownload(String url);
}

