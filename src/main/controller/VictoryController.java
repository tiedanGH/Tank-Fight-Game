package main.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Director;
import main.util.SoundEffect;

public class VictoryController {

    @FXML
    private ImageView toIndex;
    @FXML
    void mouseClickedToIndex(MouseEvent event) {
        SoundEffect.play("/resources/sound/done.wav");
        Director.toIndex();

    }
    @FXML
    void mouseEnteredToIndex(MouseEvent event) {
        toIndex.setOpacity(0.8);
        SoundEffect.play("/resources/sound/button.wav");
    }
    @FXML
    void mouseExitedToIndex(MouseEvent event) {
        toIndex.setOpacity(1);
    }
    
    @FXML
    private ImageView toNextLevel;
    @FXML
    void mouseClickedToNextLevel(MouseEvent event) {
        SoundEffect.play("/resources/sound/done.wav");
        Director.level++;
        Director.gameStart();

    }
    @FXML
    void mouseEnteredToNextLevel(MouseEvent event) {
    	toNextLevel.setOpacity(0.8);
        SoundEffect.play("/resources/sound/button.wav");
    }
    @FXML
    void mouseExitedToNextLevel(MouseEvent event) {
    	toNextLevel.setOpacity(1);
    }

}
