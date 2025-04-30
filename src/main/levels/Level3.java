package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level3 extends LevelMain {

	Level3(LevelData<Tank, Crate, Tree, Rock> levelData) {
		super(450, 490);
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
        
        tanks.add(new Tank(0, 0, true, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(890, 0, true, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(0, 520, false, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(400, 62, false, Group.enemy, Direction.stop, Direction.right, gameScene));
        tanks.add(new Tank(600, 260, false, Group.enemy, Direction.stop, Direction.right, gameScene));

		for (int i = 1; i < 6; i++) {
			crates.add(new Crate((3 + i) * 32, 3 * 60));
			crates.add(new Crate((3 + i) * 32, 3 * 60 + 32));
			
			crates.add(new Crate(66, 420 + i * 32));
			crates.add(new Crate(66 + 32, 420 + i * 32));
			crates.add(new Crate(670, 420 + i * 32));
			crates.add(new Crate(670 + 32, 420 + i * 32));
			
			crates.add(new Crate(500, (i - 1) * 32));
			crates.add(new Crate(500 + 32, (i - 1) * 32));
			crates.add(new Crate(660, 35 + i * 32));
			crates.add(new Crate(660 + 32, 35 + i * 32));
		}
		for (int i = 0; i < 27; i++) {
			crates.add(new Crate(i * 32, 320));
			crates.add(new Crate(i * 32, 320 + 32));
		}
        
		for (int j = 0; j <= 2; j++) {
			rocks.add(new Rock(60, (j + 1) * 60));
			rocks.add(new Rock(220, j * 60));
			rocks.add(new Rock(360 + j * 70, 180));
			rocks.add(new Rock(800, (j + 2) * 60));
		}
		for (int j = 0; j <= 1; j++) {
			rocks.add(new Rock(220, 490 + j * 60));
			rocks.add(new Rock(800, 410 + j * 60));
		}

        for (int j = 1; j <= 8; j++) {
        	trees.add(new Tree(-5, j * 66));
        	trees.add(new Tree(880, j * 66));
        }
        trees.add(new Tree(285, 170));
	}

}
