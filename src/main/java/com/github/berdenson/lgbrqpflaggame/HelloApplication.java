package com.github.berdenson.lgbrqpflaggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.github.berdenson.lgbrqpflaggame.Flags.getRandomFlag;
import static com.github.berdenson.lgbrqpflaggame.Flags.setFlags;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        setFlags();
        System.out.println(getRandomFlag());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("flag-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("LGBTQIA+ Flag Gayme");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        setFlags();
    }
    public static URL newURL(String url) {
        try {
            URL urls = new URL(url);
            return urls;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

