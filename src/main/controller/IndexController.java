package main.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Director;
import main.util.SoundEffect;

public class IndexController {

    @FXML
    private ImageView startGame;

    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        SoundEffect.play("/resources/sound/done.wav");
        Director.toLevelSelect();
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        startGame.setOpacity(0.8);
        SoundEffect.play("/resources/sound/button.wav");
    }

    @FXML
    void mouseExitedStartGame(MouseEvent event) {
        startGame.setOpacity(1);
    }

}
