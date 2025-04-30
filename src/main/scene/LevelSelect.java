package main.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelSelect {

	public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/resources/fxml/levelSelect.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
