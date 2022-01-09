package nijase.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import nijase.model.Level;
import nijase.model.Model;
import nijase.model.Obstacle;

public class PuzzleViewer extends JPanel {
	
	Model model;
	
	/**
	 * Create the panel.
	 */
	public PuzzleViewer(Model model) {
		this.model = model;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//WINDOW Builder
		if(model == null) {return;}
		
	
		Level level = model.getLevel();
		//g.drawString("Level has" + level.numRows + " rows", 100, 100);
		
		for(int r = 0; r < level.numRows; r++) {
			for(int c = 0; c < level.numCols; c++) {
				g.drawRect(90*c, 90*r, 80,  80);
			}
		}
		
		for(Obstacle o : model.getCurrentLevel().getObstacles()) {
			g.setColor(o.getColor());
			g.fillRect(90*o.getCol()+1, 90*o.getRow()+1, 79,  79);
		}
		
		g.setColor(Color.BLACK); //ninjase
		g.fillRect(model.getCurrentLevel().getNinjaCol()*90, model.getCurrentLevel().getNinjaRow()*90, 80, 80);
		
	}
	
}
