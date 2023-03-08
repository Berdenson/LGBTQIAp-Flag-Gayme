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

    public void setPhoto(URL url) {
        flagView.getEngine().load(url.toString());
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
