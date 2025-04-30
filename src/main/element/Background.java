package main.element;

import javafx.scene.image.Image;
import main.Director;

public class Background extends ImageElement {
    public Background() {
        super(new Image("resources/images/LevelsBackground.jpg"), 0, 0, Director.WIDTH, Director.HEIGHT);
    }
}
