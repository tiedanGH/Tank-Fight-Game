package main.element;

import javafx.scene.image.Image;

public class Rock extends ImageElement {
    public Rock(double x, double y) {
        super(new Image("resources/images/Rock.png"), x, y, 71, 61);
    }
}
