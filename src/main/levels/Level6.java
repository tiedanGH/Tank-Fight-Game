package main.levels;

import java.util.List;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;
import main.util.Direction;
import main.util.Group;

class Level6 extends LevelMain {

	Level6(LevelData<Tank, Crate, Tree, Rock> levelData) {
		super(450, 280);
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
        
        tanks.add(new Tank(10, 10, true, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(890, 10, true, Group.enemy, Direction.stop, Direction.left, gameScene));
        tanks.add(new Tank(10, 560, true, Group.enemy, Direction.stop, Direction.right, gameScene));
        tanks.add(new Tank(890, 560, true, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(228, 10, false, Group.enemy, Direction.stop, Direction.down, gameScene));
        tanks.add(new Tank(672, 560, false, Group.enemy, Direction.stop, Direction.up, gameScene));
        tanks.add(new Tank(198, 390, false, Group.enemy, Direction.stop, Direction.right, gameScene));
        tanks.add(new Tank(704, 160, false, Group.enemy, Direction.stop, Direction.left, gameScene));

        for (int i = 0; i < 24; i++) {
            crates.add(new Crate(95 + i * 32, 90));
            crates.add(new Crate(95 + i * 32, 90 + 32));
            crates.add(new Crate(95 + i * 32, 460));
            crates.add(new Crate(95 + i * 32, 460 + 32));
        }
        for (int j = 0; j < 5; j++) {
            crates.add(new Crate(300, 225 + j * 32));
            crates.add(new Crate(630, 225 + j * 32));
        }

        for (int j = 0; j < 4; j++) {
            rocks.add(new Rock(110, 175 + j * 70));
            rocks.add(new Rock(780, 175 + j * 70));
        }

        for (int i = 0; i < 10; i++) {
            trees.add(new Tree(5 + i * 96, 0));
            trees.add(new Tree(5 + i * 96, 530));
        }
        for (int j = 1; j <= 5; j++) {
            trees.add(new Tree(5, j * 88));
            trees.add(new Tree(5 + 2 * 96, j * 88));
            trees.add(new Tree(5 + 7 * 96, j * 88));
            trees.add(new Tree(870, j * 88));
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    trees.add(new Tree(440 + i * 90, 270 + j * 90));
                }
            }
        }
	}

}
