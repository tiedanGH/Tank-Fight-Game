package main.levels;

import java.util.List;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import main.element.Crate;
import main.element.ImageElement;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class RandomLevels extends LevelMain {
	
	private int level;
	private static Random rd = new Random();

	RandomLevels(LevelData<Tank, Crate, Tree, Rock> levelData, int level) {
		super(rd.nextInt(880), rd.nextInt(540));
		this.level = level;
		initLevel(levelData);
	}
	
	@Override
	public Tank initSelf(GameScene gameScene) {
		return new Tank(birthX, birthY, false, Group.self, Direction.stop, Direction.up, gameScene);
	}

	@Override
	void initLevel(LevelData<Tank, Crate, Tree, Rock> levelData) {
		List<Tank> tanks = levelData.getTanks();
        List<Crate> crates = levelData.getCrates();
        List<Rock> rocks = levelData.getRocks();
        List<Tree> trees = levelData.getTrees();
        GameScene gameScene = levelData.getGameScene();
        
		for (int i = 0; i < 4 + level * 0.5; i++) {
			int rdX = rd.nextInt(880);
            int rdY = rd.nextInt(540);
            boolean highSpeed = rd.nextInt(50) <= level;
            Direction dir = Direction.values()[rd.nextInt(Direction.values().length)];
        	Tank tank = new Tank(rdX, rdY, highSpeed, Group.enemy, Direction.stop, dir, gameScene);
        	if (isOverlapping(tank, tanks)) {
            	i--; continue;
            }
        	tanks.add(tank);
        }
		
		crates.add(new Crate(birthX - 42, birthY + 32));
		crates.add(new Crate(birthX - 42, birthY + 0 ));
		crates.add(new Crate(birthX + 70, birthY + 32));
		crates.add(new Crate(birthX + 70, birthY + 0 ));
		crates.add(new Crate(birthX + 32, birthY - 42));
		crates.add(new Crate(birthX + 0 , birthY - 42));
		crates.add(new Crate(birthX + 32, birthY + 70));
		crates.add(new Crate(birthX + 0 , birthY + 70));
        for (int i = 0; i < rd.nextInt(80, level * 25); i++) {
        	int rdX = rd.nextInt(910);
            int rdY = rd.nextInt(590);
            Crate crate = new Crate(rdX, rdY);
            if (isOverlapping(crate, tanks)) {
            	i--; continue;
            }
            crates.add(crate);
        }

        for (int i = 0; i < rd.nextInt(10, 20); i++) {
        	int rdX = rd.nextInt(900);
            int rdY = rd.nextInt(580);
            Rock rock = new Rock(rdX, rdY);
            if (isOverlapping(rock, tanks)) {
            	i--; continue;
            }
            rocks.add(rock);
        }

        for (int i = 0; i < level * 1.5; i++) {
            int rdX = rd.nextInt(880);
            int rdY = rd.nextInt(520);
            trees.add(new Tree(rdX, rdY));
        }
	}
	
	private boolean isOverlapping(ImageElement element, List<Tank> tanks) {
		Rectangle2D self = new Rectangle2D(birthX - 30, birthY - 30, 120, 120);
		if (self.intersects(element.getContour())) {
			return true;
		}
		for (Tank tank : tanks) {
			if (tank.getContour().intersects(element.getContour())) {
				return true;
			}
		}
		return false;
	}

}
