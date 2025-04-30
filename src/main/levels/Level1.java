package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level1 extends LevelMain {

	Level1(LevelData<Tank, Crate, Tree, Rock> levelData) {
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
        
		for (int i = 0; i < 4; i++) {
            tanks.add(new Tank(225 + i * 150, 75, false, Group.enemy, Direction.stop, Direction.down, gameScene));
        }

        for (int i = 2; i < 28; i++) {
            crates.add(new Crate(i * 32, 9 * 32));
            crates.add(new Crate(i * 32, 10 * 32));
        }

        for (int i = 0; i < 4; i++) {
            rocks.add(new Rock(220 + i * 150, 6 * 32));
            rocks.add(new Rock(220 + i * 150, 12 * 32));
        }

        for (int j = 0; j < 3; j++) {
            trees.add(new Tree(120, 30 + j * 80));
            trees.add(new Tree(840 - 86, 30 + j * 80));
            trees.add(new Tree(120, 525 - j * 80));
            trees.add(new Tree(840 - 86, 525 - j * 80));
        }
	}

}
