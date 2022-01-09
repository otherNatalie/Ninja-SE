package nijase.model;
import java.awt.Color;


public class Model {
	Level levels[] = new Level[3];
	int lvlNum;
	int moveCounter;
	Level currentLevel;
	

	public Model () {
		levels[0] = new Level (4, 5);
		levels[1] = new Level (3, 7);
		levels[2] = new Level (7, 7);
		lvlNum = 0; //initialize to 0;
		moveCounter = 0;

		//set-up level 1
		levels[0].add(new Obstacle(Color.yellow, 0, 3));
		levels[0].add(new Obstacle(Color.yellow, 2, 2));
		levels[0].setNinja(1, 1);

		//set-up level 2
		levels[1].add(new Obstacle(Color.yellow, 0, 2));
		levels[1].add(new Obstacle(Color.yellow, 1, 3));
		levels[1].add(new Obstacle(Color.cyan, 1, 1));
		levels[1].add(new Obstacle(Color.cyan, 2, 6));
		levels[1].add(new Obstacle(Color.red, 1, 2));
		levels[1].add(new Obstacle(Color.red, 1, 0));
		levels[1].add(new Obstacle(Color.green, 0, 6));
		levels[1].add(new Obstacle(Color.green, 1, 6));
		levels[1].setNinja(0, 1);

		//set-up level 3
		levels[2].add(new Obstacle(Color.yellow, 3, 1));
		levels[2].add(new Obstacle(Color.yellow, 5, 4));
		levels[2].add(new Obstacle(Color.cyan, 2, 1));
		levels[2].add(new Obstacle(Color.cyan, 3, 3));
		levels[2].add(new Obstacle(Color.red, 3, 2));
		levels[2].add(new Obstacle(Color.red, 5, 6));
		levels[2].add(new Obstacle(Color.green, 2, 2));
		levels[2].add(new Obstacle(Color.green, 6, 5));
		levels[2].add(new Obstacle(Color.blue, 4, 1));
		levels[2].add(new Obstacle(Color.blue, 5, 5));
		levels[2].add(new Obstacle(Color.magenta, 1, 5));
		levels[2].add(new Obstacle(Color.magenta, 3, 0));
		levels[2].setNinja(6, 6);
		
		currentLevel = levels[0].copy();
	}

	public int getLvlNum() { return lvlNum; }
	public void setLvlNum(int lvlNum) { this.lvlNum = lvlNum; }

	public Level[] getLevels() { return levels; }
	public void setLevels(Level[] levels) { this.levels = levels; }

	public Level getLevel() { return levels[lvlNum]; }
	public void setLevels(Level level) { this.levels[lvlNum] = level; }
	
	public Level getCurrentLevel() { return currentLevel; }
	public void setCurrentLevel(int num) {
		this.currentLevel = levels[num].copy();
		this.lvlNum = num;
	}
	
	public int getMoveCount() { return moveCounter; }
	public void setMoveCount(int count) { this.moveCounter = count; }
	public void incMoveCount() { this.moveCounter++; }
	public void resetMoveCount() { this.moveCounter = 0; }
	
	public boolean checkObstacleColors(int dir) { //return true if they match, direction is 0 up, 1 right, etc.
		int ud=0, lr = 0;
		switch(dir) {
		case 0: ud = -1;
		break;
		case 1: lr = +1;
		break;
		case 2: ud = +1;
		break;
		case 3: lr = -1;
		break;
		}
		
		return (currentLevel.getObstacle(currentLevel.ninjaRow+ud, currentLevel.ninjaCol+lr).getColor().
				equals(currentLevel.getObstacle(currentLevel.ninjaRow+2*ud, currentLevel.ninjaCol+2*lr).getColor()));
		
	}
	
	public void removeObstacle(int dir) {
		int ud=0, lr = 0;
		switch(dir) {
		case 0: ud = -1;
		break;
		case 1: lr = +1;
		break;
		case 2: ud = +1;
		break;
		case 3: lr = -1;
		break;
		}
		currentLevel.obstacles.remove(currentLevel.getObstacle(currentLevel.ninjaRow + ud, currentLevel.ninjaCol + lr));
		currentLevel.obstacles.remove(currentLevel.getObstacle(currentLevel.ninjaRow + 2*ud, currentLevel.ninjaCol + 2*lr));
	}

}
