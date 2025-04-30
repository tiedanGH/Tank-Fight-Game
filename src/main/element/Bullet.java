package main.element;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Director;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;
import main.util.SoundEffect;

import java.util.List;

public class Bullet extends Role {

    public Bullet(double x, double y, Group group, Direction dir, GameScene gameScene) {
        super(x, y, 0, 0, group, dir, gameScene);
        speed = 10;
        if (dir.equals(Direction.up) || dir.equals(Direction.down)) {
            width = 10;
            height = 22;
        } else if (dir.equals(Direction.left) || dir.equals(Direction.right)) {
            height = 10;
            width = 22;
        }

        if (group.equals(Group.self)) {
            switch (dir) {
                case up:
                    image = new Image("resources/images/bullet-self-up.png");
                    break;
                case down:
                    image = new Image("resources/images/bullet-self-down.png");
                    break;
                case left:
                    image = new Image("resources/images/bullet-self-left.png");
                    break;
                case right:
                    image = new Image("resources/images/bullet-self-right.png");
                    break;
                default:
            }
        } else {
            switch (dir) {
                case up:
                    image = new Image("resources/images/bullet-enemy-up.png");
                    break;
                case down:
                    image = new Image("resources/images/bullet-enemy-down.png");
                    break;
                case left:
                    image = new Image("resources/images/bullet-enemy-left.png");
                    break;
                case right:
                    image = new Image("resources/images/bullet-enemy-right.png");
                    break;
                default:
            }
        }
    }

    @Override
    public void move() {
        switch (dir) {
            case up:
                y -= speed;
                break;
            case down:
                y += speed;
                break;
            case left:
                x -= speed;
                break;
            case right:
                x += speed;
                break;
            default:
        }

        if (x < 0 || y < 0 || x > Director.WIDTH || y > Director.HEIGHT) {
            gameScene.bullets.remove(this);
        }
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        if (!alive) {
            gameScene.bullets.remove(this);
            gameScene.explodes.add(new Explode(x, y, gameScene));
            SoundEffect.play("/resources/sound/explosion.wav");
            return;
        }
        super.paint(graphicsContext);
        move();
    }

    public boolean impactTank(Tank tank) {
        if (tank != null && !tank.group.equals(this.group) && getContour().intersects(tank.getContour())) {
            tank.setAlive(false);
            alive = false;
            if (tank.group.equals(Group.self)) {
            	gameScene.explodes.add(new Explode(tank.x + 20, tank.y + 40, gameScene));
            	gameScene.explodes.add(new Explode(tank.x + 15, tank.y + 25, gameScene));
            	gameScene.explodes.add(new Explode(tank.x + 35, tank.y + 15, gameScene));
            	gameScene.explodes.add(new Explode(tank.x + 40, tank.y + 45, gameScene));
            }
            return true;
        }
        return false;
    }

    public void impactTanks(List<Tank> tanks) {
        for (Tank t : tanks) {
            impactTank(t);
        }
    }

    public boolean impactCrate(Crate crate) {
        if (crate != null && getContour().intersects(crate.getContour())) {
            alive = false;
            gameScene.crates.remove(crate);
            return true;
        }
        return false;
    }

    public void impactCrates(List<Crate> crates) {
        for (int i = 0; i < crates.size(); i++) {
            Crate crate = crates.get(i);
            impactCrate(crate);
        }
    }

    public boolean impactRock(Rock rock) {
        if (rock != null && getContour().intersects(rock.getContour())) {
            alive = false;
            return true;
        }
        return false;
    }

    public void impactRocks(List<Rock> rocks) {
        for (int i = 0; i < rocks.size(); i++) {
            Rock rock = rocks.get(i);
            impactRock(rock);
        }
    }
}
