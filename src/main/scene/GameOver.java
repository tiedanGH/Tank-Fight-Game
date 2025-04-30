package main.scene;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import main.Director;
import main.levels.LevelMain;
import main.util.SoundEffect;

public class GameOver {

    public static void load(Stage stage, boolean success) {
        try {
        	FXMLLoader fxmlLoader;
        	if (success) {
        		if (Director.level == LevelMain.TotalLevel) {
        			SoundEffect.play("/resources/sound/levelClear.wav");
        			fxmlLoader = new FXMLLoader(Index.class.getResource("/resources/fxml/levelClear.fxml"));
        		} else {
        			SoundEffect.play("/resources/sound/victory.mp3");
        			fxmlLoader = new FXMLLoader(Index.class.getResource("/resources/fxml/victory.fxml"));
        		}
        	} else {
        		SoundEffect.play("/resources/sound/defeated.mp3");
        		fxmlLoader = new FXMLLoader(Index.class.getResource("/resources/fxml/defeated.fxml"));
        	}
            Parent root = fxmlLoader.load();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
