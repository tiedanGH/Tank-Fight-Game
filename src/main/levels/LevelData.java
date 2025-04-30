package main.levels;

import java.util.List;
import main.scene.GameScene;

public class LevelData<Tank, Crate, Tree, Rock> {
	
	private List<Tank> tanks;
    private List<Crate> crates;
    private List<Rock> rocks;
    private List<Tree> trees;
    private GameScene gameScene;

    public LevelData(List<Tank> tanks, List<Crate> crates, List<Rock> rocks, List<Tree> trees, GameScene gameScene) {
        this.tanks = tanks;
        this.crates = crates;
        this.rocks = rocks;
        this.trees = trees;
        this.gameScene = gameScene;
    }
    
    public List<Tank> getTanks() { return tanks; }
    public List<Crate> getCrates() { return crates; }
    public List<Rock> getRocks() { return rocks; }
    public List<Tree> getTrees() { return trees; }
    public GameScene getGameScene() { return gameScene; }

}
