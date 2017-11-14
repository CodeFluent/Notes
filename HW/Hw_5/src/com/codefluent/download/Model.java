package com.codefluent.download;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Model {

    private String urlPath;



    private String filePath;
    private String status;


    public String getUrlPath() {
        return urlPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String path) {
        this.filePath = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void startDownload(String url) {
        String ext = url.substring(url.lastIndexOf("."), url.length());
        try {
            URL path = new URL(url);

            System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");

            BufferedReader in = new BufferedReader(new InputStreamReader(path.openStream()));
            PrintWriter writer = new PrintWriter(this.getFilePath()+ "downloaded_file" + ext);

            String line;
            while ((line = in.readLine()) != null) {
//                System.out.println(line);
                writer.println(line);
            }
            in.close();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }



}
