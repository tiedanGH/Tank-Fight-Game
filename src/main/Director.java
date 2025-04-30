package main;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.scene.GameOver;
import main.scene.GameScene;
import main.scene.Index;
import main.scene.LevelSelect;

public final class Director {

    public static final double WIDTH = 960, HEIGHT = 640;
    
    public static int level = 1;
    public static boolean sound = true;
    
    private static Stage stage;
    private static GameScene gameScene = new GameScene();

    private Director() {}

    public static void init(Stage stage) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root , WIDTH, HEIGHT);
        stage.setTitle("Tank Fight");
        stage.getIcons().add(new Image("resources/images/icon.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        Director.stage = stage;
        toIndex();
        stage.show();
    }

    public static void toIndex() {
        Index.load(stage);
    }
    
    public static void toLevelSelect() {
    	LevelSelect.load(stage);
    }
    
    public static void escBacktoLevelSelect() {
    	gameScene.clear(stage);
    	toLevelSelect();
    }

    public static void gameOver(boolean success) {
        gameScene.clear(stage);
        GameOver.load(stage, success);
    }

    public static void gameStart() {
        gameScene.init(stage, level);
    }
    
}
