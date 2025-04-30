package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level2 extends LevelMain {

	Level2(LevelData<Tank, Crate, Tree, Rock> levelData) {
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
            tanks.add(new Tank(75 + i * 250, 75, false, Group.enemy, Direction.stop, Direction.down, gameScene));
        }

		for (int j = 1; j < 6; j++) {
    		crates.add(new Crate(0, j * 32));
    		crates.add(new Crate(6 * 32, j * 32));
    		crates.add(new Crate(8 * 32, j * 32));
    		crates.add(new Crate(14 * 32, j * 32));
    		crates.add(new Crate(15 * 32, j * 32));
    		crates.add(new Crate(21 * 32, j * 32));
    		crates.add(new Crate(23 * 32, j * 32));
    		crates.add(new Crate(29 * 32, j * 32));
    		
    		crates.add(new Crate(7 * 32, 410 + j * 32));
    		crates.add(new Crate(8 * 32, 410 + j * 32));
    		crates.add(new Crate(21 * 32, 410 + j * 32));
    		crates.add(new Crate(22 * 32, 410 + j * 32));
    	}
        for (int i = 0; i < 30; i++) {
        	if (i != 7 && i != 22) {
        		crates.add(new Crate(i * 32, 0));
        		crates.add(new Crate(i * 32, 6 * 32));
        	}
            crates.add(new Crate(i * 32, 8 * 32));
        }

        for (int i = 0; i < 3; i++) {
            rocks.add(new Rock(140 + i * 70, 380));
            rocks.add(new Rock(620 + i * 70, 380));
        }

        for (int i = 0; i < 12; i++) {
            trees.add(new Tree(i * 80, 9 * 32));
        }
	}

}
