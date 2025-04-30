package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level5 extends LevelMain {

	Level5(LevelData<Tank, Crate, Tree, Rock> levelData) {
		super(450, 432);
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
        
        tanks.add(new Tank(200, 10, true, Group.enemy, Direction.stop, Direction.right, gameScene));
        tanks.add(new Tank(700, 570, true, Group.enemy, Direction.stop, Direction.left, gameScene));
        tanks.add(new Tank(10, 280, false, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(885, 280, false, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(210, 280, false, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(690, 280, false, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(450, 120, true, Group.enemy, Direction.stop, Direction.down, gameScene));

        for (int i = 0; i < 25; i++) {
            crates.add(new Crate(80 + i * 32, 80));
            crates.add(new Crate(80 + i * 32, 80 + 32 * 13));
        }
        for (int j = 0; j < 12; j++) {
            crates.add(new Crate(80, 112 + j * 32));
            crates.add(new Crate(816 + 32, 112 + j * 32));
        }
        for (int i = 0; i < 19; i++) {
            crates.add(new Crate(80 + (i + 3) * 32, 80 + 32 * 3));
            crates.add(new Crate(80 + (i + 3) * 32, 80 + 32 * 10));
        }
        for (int j = 0; j < 6; j++) {
            crates.add(new Crate(176, 112 + (j + 3) * 32));
            crates.add(new Crate(752, 112 + (j + 3) * 32));
        }
        for (int i = 0; i < 5; i++) {
            crates.add(new Crate(272 + i * 32, 80 + 32 * 6));
            crates.add(new Crate(272 + i * 32, 80 + 32 * 7));
            crates.add(new Crate(272 + (i + 8) * 32, 80 + 32 * 6));
            crates.add(new Crate(272 + (i + 8) * 32, 80 + 32 * 7));
        }

        rocks.add(new Rock(10, 10));
        rocks.add(new Rock(10, 540));
        rocks.add(new Rock(880, 10));
        rocks.add(new Rock(880, 540));
        rocks.add(new Rock(440, 275));

        for (int i = 0; i < 5; i++) {
            trees.add(new Tree(240 + i * 100, 200));
            trees.add(new Tree(240 + i * 100, 330));
        }
        for (int j = 0; j < 4; j++) {
            trees.add(new Tree(105, 140 + j * 80));
            trees.add(new Tree(775, 140 + j * 80));
        }
        for (int i = 0; i < 2; i++) {
            trees.add(new Tree(220 + i * 100, 100));
            trees.add(new Tree(220 + i * 100, 420));
            trees.add(new Tree(560 + i * 100, 100));
            trees.add(new Tree(560 + i * 100, 420));
        }
	}

}
