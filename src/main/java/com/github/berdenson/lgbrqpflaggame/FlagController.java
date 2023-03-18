package com.github.berdenson.lgbrqpflaggame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.net.URL;

import static com.github.berdenson.lgbrqpflaggame.Flags.getRandomFlag;

public class FlagController {
    @FXML
    private WebView flagView;
    @FXML
    private Button newFlag;
    @FXML
    private Button pokemonButton;
    private Thread identityThread;
    private Flag flag;

    /**
     * sets the photo
     * @param url a url
     */
    public void setPhoto(String url) {
        flagView.getEngine().load(url);
        flagView.setZoom(0.5);
    }

    /**
     * reveals the identity
     * @param ident (identity (Quinn make better names)) just the name
     */
    private void revealIdentity(String ident) {
        pokemonButton.setText(ident);
    }

    /**
     * reveals the identity when button pushed or something
     */
    @FXML
    private void revealIdentityButton() {
        revealIdentity(flag.name());
    }

    /**
     * generates a new identity (also a button)
     */
    @FXML
    private void newIdent() {
        revealIdentity("Press me to reveal the identity");
        flag = getRandomFlag();
        setPhoto(flag.url());
    }
}
