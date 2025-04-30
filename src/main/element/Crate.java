package main.element;

import javafx.scene.image.Image;

public class Crate extends ImageElement {
    public Crate(double x, double y) {
        super(new Image("resources/images/Crate.png"), x, y, 32, 32);
    }
}
