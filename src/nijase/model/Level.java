package nijase.model;

import java.util.ArrayList;

public class Level {
	public final int numRows;
	public final int numCols; 
	ArrayList<Obstacle> obstacles;
	int ninjaRow;
	int ninjaCol;

	public Level(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		obstacles = new ArrayList<Obstacle>();
	}

	public Level(int numRows, int numCols, ArrayList<Obstacle> obstacles, int ninjaRow, int ninjaCol) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.obstacles = obstacles;
		this.ninjaCol = ninjaCol;
		this.ninjaRow = ninjaRow;
	}
	
	void add(Obstacle o){ obstacles.add(o);	}
	public void remove(Obstacle o) { obstacles.remove(o); } //not sure if this is needed
	public void setNinja(int r, int c) {
		ninjaRow = r;
		ninjaCol = c;
	}
	
	public boolean isEmpty(int row, int col) {
		for(Obstacle o : obstacles) {
			if(o.col == col && o.row == row)
				return false;
		}
		return true;
	}
	
	public Obstacle getObstacle(int row, int col) {
		for(Obstacle o : obstacles) {
			if(o.col == col && o.row == row)
				return o;
		}
		return null;
	}

	public Level copy() {
		ArrayList<Obstacle> tempList = new ArrayList<Obstacle>();;
		for(Obstacle o : obstacles) {
			tempList.add(new Obstacle(o.getColor(), o.getRow(), o.getCol()));
		}
		return new Level(this.numRows, this.numCols, tempList, this.ninjaRow, this.ninjaCol);
	}
	
	public ArrayList<Obstacle> getObstacles() { return obstacles; }
	
	public int getNinjaRow() { return ninjaRow; }
//	public void setLvlNum(int lvlNum) { this.lvlNum = lvlNum; }

	public int getNinjaCol() { return ninjaCol; }

}
