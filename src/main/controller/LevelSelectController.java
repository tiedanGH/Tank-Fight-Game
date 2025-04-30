package main.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Director;
import main.util.SoundEffect;

public class LevelSelectController {
    
    @FXML
    private ImageView level1;
    @FXML
    void mouseClickedLevel1(MouseEvent event) {
        startGame(1);
    }
	@FXML
    void mouseEnteredLevel1(MouseEvent event) {
		mouseEnteredImage(level1);
    }
    @FXML
    void mouseExitedLevel1(MouseEvent event) {
    	mouseExitedImage(level1);
    }
    
    @FXML
    private ImageView level2;
    @FXML
    void mouseClickedLevel2(MouseEvent event) {
        startGame(2);
    }
	@FXML
    void mouseEnteredLevel2(MouseEvent event) {
		mouseEnteredImage(level2);
    }
    @FXML
    void mouseExitedLevel2(MouseEvent event) {
    	mouseExitedImage(level2);
    }
    
    @FXML
    private ImageView level3;
    @FXML
    void mouseClickedLevel3(MouseEvent event) {
        startGame(3);
    }
	@FXML
    void mouseEnteredLevel3(MouseEvent event) {
		mouseEnteredImage(level3);
    }
    @FXML
    void mouseExitedLevel3(MouseEvent event) {
    	mouseExitedImage(level3);
    }
    
    @FXML
    private ImageView level4;
    @FXML
    void mouseClickedLevel4(MouseEvent event) {
        startGame(4);
    }
	@FXML
    void mouseEnteredLevel4(MouseEvent event) {
		mouseEnteredImage(level4);
    }
    @FXML
    void mouseExitedLevel4(MouseEvent event) {
    	mouseExitedImage(level4);
    }
    
    @FXML
    private ImageView level5;
    @FXML
    void mouseClickedLevel5(MouseEvent event) {
        startGame(5);
    }
	@FXML
    void mouseEnteredLevel5(MouseEvent event) {
		mouseEnteredImage(level5);
    }
    @FXML
    void mouseExitedLevel5(MouseEvent event) {
    	mouseExitedImage(level5);
    }
    
    @FXML
    private ImageView level6;
    @FXML
    void mouseClickedLevel6(MouseEvent event) {
        startGame(6);
    }
	@FXML
    void mouseEnteredLevel6(MouseEvent event) {
		mouseEnteredImage(level6);
    }
    @FXML
    void mouseExitedLevel6(MouseEvent event) {
    	mouseExitedImage(level6);
    }
    
    @FXML
    private ImageView level7;
    @FXML
    void mouseClickedLevel7(MouseEvent event) {
        startGame(7);
    }
    
    
    private void mouseEnteredImage(ImageView imageView) {
    	imageView.setOpacity(0.8);
    	SoundEffect.play("/resources/sound/button.wav");
    }
    
    private void mouseExitedImage(ImageView image) {
    	image.setOpacity(1);
    }
    
    private void startGame(int level) {
    	SoundEffect.play("/resources/sound/done.wav");
    	Director.level = level;
        Director.gameStart();
    }

}
