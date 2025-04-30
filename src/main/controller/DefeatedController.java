package main.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.Director;
import main.levels.LevelMain;
import main.util.SoundEffect;

public class DefeatedController {

	@FXML
    private ImageView tryAgain;
    @FXML
    void mouseClickedTryAgain(MouseEvent event) {
        SoundEffect.play("/resources/sound/done.wav");
        Director.gameStart();
    }
    @FXML
    void mouseEnteredTryAgain(MouseEvent event) {
    	tryAgain.setOpacity(0.8);
        SoundEffect.play("/resources/sound/button.wav");
    }
    @FXML
    void mouseExitedTryAgain(MouseEvent event) {
    	tryAgain.setOpacity(1);
    }
	
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
    private Text levelInfo;
    @FXML
    public void initialize() {
    	if (Director.level > LevelMain.TotalLevel) {
    		levelInfo.setText("Your Score: " + Integer.toString(Director.level - 7));
    		Director.level = 7;
		}
    }

}
