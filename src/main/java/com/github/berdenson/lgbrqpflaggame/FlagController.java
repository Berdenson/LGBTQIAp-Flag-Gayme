package com.github.berdenson.lgbrqpflaggame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.github.berdenson.lgbrqpflaggame.Constants.DELAY_TIME;
import static com.github.berdenson.lgbrqpflaggame.Flags.getRandomFlag;

public class FlagController {
    @FXML
    private ImageView imageView;
    @FXML
    private Button newFlag;
    @FXML
    private Button pokemonButton;
    private Thread identityThread;
    private Flag flag;

    public void setPhoto(URL url) {
        InputStream is = null;
        try {
            URLConnection urlConnection = url.openConnection();
            is = urlConnection.getInputStream();
        } catch (IOException e) {
        }
        Image image = new Image(is);
        imageView.setImage(image);
    }
    private void revealIdentity(String ident) {
        pokemonButton.setText(ident);
    }
    @FXML
    private void revealIdentityButton() {
        revealIdentity(flag.name());
    }
    @FXML
    private void newIdent() {
        revealIdentity("Press me to real the identity");
        flag = getRandomFlag();
        setPhoto(flag.url());
    }
}
