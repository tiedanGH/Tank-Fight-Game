package main.scene;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Director;
import main.element.Background;
import main.element.Bullet;
import main.element.Crate;
import main.element.Explode;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.levels.LevelData;
import main.levels.LevelMain;

import java.util.ArrayList;
import java.util.List;


public class GameScene {

    private Canvas canvas = new Canvas(Director.WIDTH, Director.HEIGHT);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    private KeyProcess keyProcess = new KeyProcess();
    private Refresh refresh = new Refresh();
    private boolean running = false;
    private int countDown;

    private Background background = new Background();
    private Tank self = null;
    public List<Bullet> bullets = new ArrayList<>();
    public List<Tank> tanks = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();
    public List<Crate>  crates = new ArrayList<>();
    public List<Rock> rocks = new ArrayList<>();
    public List<Tree> trees = new ArrayList<>();
    
	private LevelData<Tank, Crate, Tree, Rock> levelData = new LevelData<Tank, Crate, Tree, Rock>(tanks, crates, rocks, trees, this);
    private LevelMain levelMain;

    private void paint() {
        background.paint(graphicsContext);
        self.paint(graphicsContext);
        self.impact(tanks);
        self.impact(crates);
        self.impact(rocks);

        for (int i = 0; i < bullets.size(); i++) {
        	Bullet b = bullets.get(i);
            b.paint(graphicsContext);
            b.impactCrates(crates);
            b.impactTanks(tanks);
            b.impactRocks(rocks);
            b.impactTank(self);
        }

        for (int i = 0; i < tanks.size(); i++) {
        	Tank tank = tanks.get(i);
            tank.paint(graphicsContext);
            tank.impact(crates);
            tank.impact(self);
            tank.impact(rocks);
            tank.impact(tanks);
        }
        
        for (Crate crate: crates) {
            crate.paint(graphicsContext);
        }

        for (Rock rock: rocks) {
            rock.paint(graphicsContext);
        }

        for (Tree tree: trees) {
            tree.paint(graphicsContext);
        }
        
        for (int i = 0; i < explodes.size(); i++) {
        	Explode e = explodes.get(i);
            e.paint(graphicsContext);
        }

        graphicsContext.setFill(Color.RED);
        graphicsContext.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        graphicsContext.fillText("LEVEL:", 855, 30);
        graphicsContext.fillText(Integer.toString(Director.level), 935, 30);
        graphicsContext.fillText("ENEMY:", 845, 60);
        graphicsContext.fillText(Integer.toString(tanks.size()), 935, 60);
        if (!Director.sound) {
        	graphicsContext.drawImage(new Image("resources/images/mute.png"), 900, 75, 45, 45);
        }

        if(!self.isAlive()) {
        	if (countDown == 0) {
        		Director.gameOver(false);
        	} else {
        		countDown--;
        	}
        } else if(tanks.isEmpty()) {
            Director.gameOver(true);
        }
    }

    public void init(Stage stage, int level) {
        AnchorPane root = new AnchorPane(canvas);
        stage.getScene().setRoot(root);
        stage.getScene().setOnKeyReleased(keyProcess);
        stage.getScene().setOnKeyPressed(keyProcess);
        running = true;
        countDown = 30;
        levelMain = LevelMain.newLevel(levelData, level);
        self = levelMain.initSelf(this);
        refresh.start();
    }

    public void clear(Stage stage) {
        stage.getScene().removeEventHandler(KeyEvent.KEY_PRESSED, keyProcess);
        stage.getScene().removeEventHandler(KeyEvent.KEY_RELEASED, keyProcess);
        refresh.stop();
        self = null;
        tanks.clear();
        bullets.clear();
        crates.clear();
        explodes.clear();
        rocks.clear();
        trees.clear();
    }
    

    private class Refresh extends AnimationTimer {

        @Override
        public void handle(long now) {
            if(running) {
                paint();
            }
        }
    }
    
    private class KeyProcess implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            KeyCode keyCode = event.getCode();

            if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                if(keyCode.equals(KeyCode.SPACE)) {
                    pauseOrContinue();
                }
                if (keyCode.equals(KeyCode.ESCAPE)) {
                	Director.escBacktoLevelSelect();
                }
                if (keyCode.equals(KeyCode.V)) {
                	Director.gameOver(true);
                }
                
                if (self != null) self.released(keyCode);
            } else if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            	if (keyCode.equals(KeyCode.M)) {
                	Director.sound = !Director.sound;
                }
            	
                if (self != null) self.pressed(keyCode);
            }
        }
    }

    private void pauseOrContinue() {
        running = !running;
    }
    
}
