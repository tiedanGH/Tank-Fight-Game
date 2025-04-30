package main.element;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.scene.GameScene;

public abstract class ImageElement {

    Image image;
    double x;
    double y;
	double width;
	double height;
    GameScene gameScene;

    protected ImageElement(Image image, double x, double y, double width, double height, GameScene gameScene) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameScene = gameScene;
    }

    protected ImageElement(Image image, double x, double y, double width, double height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, x, y, width, height);
    }

    public Rectangle2D getContour() {
        return new Rectangle2D(x, y, width, height);
    }

}
