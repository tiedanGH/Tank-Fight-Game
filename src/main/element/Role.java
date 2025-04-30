package main.element;

import javafx.scene.image.Image;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

import java.util.HashMap;
import java.util.Map;

public abstract class Role extends ImageElement {

    boolean alive = true;
    Group group;
    Direction dir;
    double speed;
    Map<String, Image> imageMap = new HashMap<>();

    public Role(double x, double y, double width, double height, Group group, Direction dir, GameScene gameScene) {
        super(null, x, y, width, height, gameScene);
        this.group = group;
        this.dir = dir;
    }

    public abstract void move();

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
