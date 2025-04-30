package main.levels;

import main.element.Crate;
import main.element.Rock;
import main.element.Tank;
import main.element.Tree;
import main.scene.GameScene;

public abstract class LevelMain {
	
	public static final int TotalLevel = 6;
	
	protected int birthX;
	protected int birthY;
	
	protected LevelMain(int birthX, int birthY) {
		this.birthX = birthX;
		this.birthY = birthY;
	}
	
	abstract public Tank initSelf(GameScene gameScene);
	abstract void initLevel(LevelData<Tank, Crate, Tree, Rock> levelData);

	public static LevelMain newLevel(LevelData<Tank, Crate, Tree, Rock> levelData, int level) {
		if (level == 1) return new Level1(levelData);
		if (level == 2) return new Level2(levelData);
		if (level == 3) return new Level3(levelData);
		if (level == 4) return new Level4(levelData);
		if (level == 5) return new Level5(levelData);
		if (level == 6) return new Level6(levelData);
		return new RandomLevels(levelData, level);
	}
	
}
