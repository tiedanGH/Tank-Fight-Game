package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level4 extends LevelMain {

	Level4(LevelData<Tank, Crate, Tree, Rock> levelData) {
		super(450, 370);
		initLevel(levelData);
	}
	
	@Override
	public Tank initSelf(GameScene gameScene) {
		return new Tank(birthX, birthY, false, Group.self, Direction.stop, Direction.up, gameScene);
	}

	void initLevel(LevelData<Tank, Crate, Tree, Rock> levelData) {
        List<Tank> tanks = levelData.getTanks();
        List<Crate> crates = levelData.getCrates();
        List<Rock> rocks = levelData.getRocks();
        List<Tree> trees = levelData.getTrees();
        GameScene gameScene = levelData.getGameScene();

        tanks.add(new Tank(10, 10, true, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(890, 10, true, Group.enemy, Direction.stop, Direction.left, gameScene));
        tanks.add(new Tank(10, 570, true, Group.enemy, Direction.stop, Direction.right, gameScene));
        tanks.add(new Tank(890, 570, true, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(420, 190, false, Group.enemy, Direction.stop, Direction.left, gameScene));
        tanks.add(new Tank(490, 190, false, Group.enemy, Direction.stop, Direction.right, gameScene));

        for (int i = 0; i < 9; i++) {
            crates.add(new Crate(85 + i * 32, 80));
            crates.add(new Crate(85 + i * 32, 80 + 32));
            crates.add(new Crate(85 + i * 32, 80 + 32 * 12));
            crates.add(new Crate(85 + i * 32, 80 + 32 * 13));
            crates.add(new Crate(590 + i * 32, 80));
            crates.add(new Crate(590 + i * 32, 80 + 32));
            crates.add(new Crate(590 + i * 32, 80 + 32 * 12));
            crates.add(new Crate(590 + i * 32, 80 + 32 * 13));
        }
        for (int j = 0; j < 10; j++) {
            crates.add(new Crate(181, 144 + j * 32));
            crates.add(new Crate(181 + 1 * 32, 144 + j * 32));
            crates.add(new Crate(181 + 2 * 32, 144 + j * 32));
            crates.add(new Crate(686, 144 + j * 32));
            crates.add(new Crate(686 + 1 * 32, 144 + j * 32));
            crates.add(new Crate(686 + 2 * 32, 144 + j * 32));
        }
        
        for (int i = 0; i < 3; i++) {
	        rocks.add(new Rock(380 + i * 70, 90));
	        rocks.add(new Rock(380 + i * 70, 280));
	        rocks.add(new Rock(380 + i * 70, 470));
        }
        
        for (int i = 0; i < 16; i++) {
            trees.add(new Tree(i * 80, 0));
            trees.add(new Tree(i * 80, 530));
        }
        for (int j = 1; j <= 6; j++) {
            trees.add(new Tree(0, j * 75));
            trees.add(new Tree(880, j * 75));
        }
    }

}
