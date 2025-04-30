package main.element;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.Director;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;
import main.util.SoundEffect;

import java.util.List;
import java.util.Random;

public class Tank extends Role {

    Direction pdir;
    boolean keyup, keydown, keyleft, keyright;
    double oldx, oldy;
    public static Random random = new Random();

    public Tank(double x, double y, boolean highSpeed, Group group, Direction dir, Direction pdir, GameScene gameScene) {
        super(x, y, 60, 60, group, dir, gameScene);
        this.pdir = pdir;
        if (highSpeed) {
        	speed = 8;
        } else {
        	speed = 5;
        }
        if(group.equals(Group.self)) {
            imageMap.put("up", new Image("resources/images/tank-self-up.png"));
            imageMap.put("down", new Image("resources/images/tank-self-down.png"));
            imageMap.put("left", new Image("resources/images/tank-self-left.png"));
            imageMap.put("right", new Image("resources/images/tank-self-right.png"));
        } else {
        	if (highSpeed) {
        		imageMap.put("up", new Image("resources/images/tank-enemyhighspeed-up.jpg"));
	            imageMap.put("down", new Image("resources/images/tank-enemyhighspeed-down.jpg"));
	            imageMap.put("left", new Image("resources/images/tank-enemyhighspeed-left.jpg"));
	            imageMap.put("right", new Image("resources/images/tank-enemyhighspeed-right.jpg"));
        	} else {
	            imageMap.put("up", new Image("resources/images/tank-enemy-up.png"));
	            imageMap.put("down", new Image("resources/images/tank-enemy-down.png"));
	            imageMap.put("left", new Image("resources/images/tank-enemy-left.png"));
	            imageMap.put("right", new Image("resources/images/tank-enemy-right.png"));
        	}
        }

    }


    public void pressed(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                keyup = true;
                break;
            case DOWN:
                keydown = true;
                break;
            case LEFT:
                keyleft = true;
                break;
            case RIGHT:
                keyright = true;
                break;
			default:
        }
        redirect();
    }

    public void released(KeyCode keyCode) {
        switch (keyCode) {
            case F:
                openFire();
                break;
            case UP:
                keyup = false;
                break;
            case DOWN:
                keydown = false;
                break;
            case LEFT:
                keyleft = false;
                break;
            case RIGHT:
                keyright = false;
                break;
            default:
        }
        redirect();
    }

    public void redirect() {
        if(keyup && !keydown && !keyleft && !keyright) dir = Direction.up;
        else if(!keyup && keydown && !keyleft && !keyright) dir = Direction.down;
        else if(!keyup && !keydown && keyleft && !keyright) dir = Direction.left;
        else if(!keyup && !keydown && !keyleft && keyright) dir = Direction.right;
        else if(!keyup && !keydown && !keyleft && !keyright) dir = Direction.stop;
    }

    @Override
    public void move() {
        oldx = x;
        oldy = y;
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

        if(dir != Direction.stop) {
            pdir = dir;
        }

        if(x < 0) x = 0;
        if(y < 0) y = 0;
        if(x > Director.WIDTH - width - 5) x = Director.WIDTH - width - 5;
        if(y > Director.HEIGHT - height - 30) y = Director.HEIGHT - height - 30;

        if(group.equals(Group.enemy)) {
            int i = random.nextInt(60);
            switch (i) {
                case 0:
                    Direction d[] = Direction.values();
                    dir = d[random.nextInt(d.length)];
                    break;
                case 1:
                    openFire();
                    break;
            }
        }
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        if(!alive) {
        	if (group.equals(Group.enemy)) {
        		gameScene.tanks.remove(this);
        	}
            return;
        }
        switch (pdir) {
            case up:
                image = imageMap.get("up");
                break;
            case down:
                image = imageMap.get("down");
                break;
            case left:
                image = imageMap.get("left");
                break;
            case right:
                image = imageMap.get("right");
                break;
            default:
        }
        super.paint(graphicsContext);
        move();
    }

    private void openFire() {
        double bulletx = x;
        double bullety = y;
        switch (pdir) {
            case up:
                bulletx = x + 25;
                bullety = y;
                break;
            case down:
                bulletx = x + 25;
                bullety = y + height;
                break;
            case left:
                bulletx = x;
                bullety = y + 25;
                break;
            case right:
                bulletx = x + width;
                bullety = y + 25;
                break;
            default:
        }
        SoundEffect.play("/resources/sound/attack.mp3");
        gameScene.bullets.add(new Bullet(bulletx, bullety, group, pdir, gameScene));
    }

    public boolean impact(ImageElement element) {
        if(element != null && !element.equals(this) && getContour().intersects(element.getContour())) {
            x = oldx;
            y = oldy;
            return true;
        }
        return false;
    }

    public void impact(List<? extends ImageElement> elements) {
        for (ImageElement element : elements) {
            impact(element);
        }
    }

}
