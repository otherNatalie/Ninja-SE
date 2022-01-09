package nijase.model;

import java.awt.Color;

public class Obstacle {
	Color color;
	int row;
	int col;
	
	public Obstacle(Color color, int r, int c) {
		this.color = color;
		row = r;
		col = c;
	}
	
	public void moveObstacle(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void setRow(int r) { row = r; }
	public int getRow() { return row; }
	
	public void setCol(int c) { col = c; }
	public int getCol() { return col; }
	
	public Color getColor() { return color; }
	
}
