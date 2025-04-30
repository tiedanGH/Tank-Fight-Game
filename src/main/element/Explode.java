package main.element;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.scene.GameScene;

public class Explode extends ImageElement {
    private int count = 0;
    private static Image[] images = new Image[] {
            new Image("resources/images/explode1.png"),
            new Image("resources/images/explode2.png"),
            new Image("resources/images/explode3.png"),
            new Image("resources/images/explode4.png"),
            new Image("resources/images/explode5.png"),
            new Image("resources/images/explode6.png"),
            new Image("resources/images/explode7.png"),
            new Image("resources/images/explode8.png"),
            new Image("resources/images/explode9.png"),
    };

    public Explode(double x, double y, GameScene gameScene) {
        super(null, x, y, 0, 0, gameScene);
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        if(count >= images.length) {
            gameScene.explodes.remove(this);
            return;
        }
        image = images[count];
        double ex = x - image.getWidth()/2;
        double ey = y - image.getHeight()/2;
        graphicsContext.drawImage(image, ex, ey);
        count++;
    }
}
