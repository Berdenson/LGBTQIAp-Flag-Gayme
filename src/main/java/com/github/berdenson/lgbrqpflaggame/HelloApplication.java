package com.github.berdenson.lgbrqpflaggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.github.berdenson.lgbrqpflaggame.Flags.getRandomFlag;
import static com.github.berdenson.lgbrqpflaggame.Flags.setFlags;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ParseException {
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
    }

    /**
     * makes a url cause it's a pain
     * @param url :) url (it's a url string)
     * @return the B) cooler url (It's a url object)
     */
    public static URL newURL(String url) {
        try {
            URL urls = new URL(url);
            return urls;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

