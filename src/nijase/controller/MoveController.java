package nijase.controller;

import nijase.model.Model;
import nijase.view.Application;

public class MoveController {
	Application app;
	Model model;
	int direction; //0 up, 1 right, 2 down, 3 left
	
	int nRow, nCol;

	public MoveController(Application app, Model model, int direction) {
		this.app = app;
		this.model = model;
		this.direction = direction;
		nRow = model.getCurrentLevel().getNinjaRow();
		nCol = model.getCurrentLevel().getNinjaCol();
		app.repaint();
	}

	public void process() {
		
		int ud=0, lr = 0;
		switch(direction) {
		case 0: ud = -1;
		break;
		case 1: lr = +1;
		break;
		case 2: ud = +1;
		break;
		case 3: lr = -1;
		break;
		}
		
		if(validRC(direction) && model.getCurrentLevel().isEmpty(nRow + ud, nCol + lr)) { //target cell is empty
			model.getCurrentLevel().setNinja(nRow + ud, nCol + lr);
			model.incMoveCount();
			app.getMoveCounter().setText(model.getMoveCount() + " moves");
		}
		else if(validRC2(direction) && model.getCurrentLevel().isEmpty(nRow + 2*ud, nCol + 2*lr)) { //check if the space *across* the obstacle is empty
			model.getCurrentLevel().getObstacle(nRow + ud, nCol + lr).moveObstacle(nRow+2*ud, nCol +2*lr);
			model.getCurrentLevel().setNinja(nRow + ud, nCol+ lr);
			model.incMoveCount();
			app.getMoveCounter().setText(model.getMoveCount() + " moves");
		}
		else if(validRC2(direction) && model.checkObstacleColors(direction)) { //remove obstacle
			model.removeObstacle(direction);
			model.getCurrentLevel().setNinja(nRow + ud, nCol+ lr);
			model.incMoveCount();
			if(model.getCurrentLevel().getObstacles().isEmpty()) {
				app.getWinSign().setText("You won!");
			}
			app.getMoveCounter().setText(model.getMoveCount() + " moves");
		}
	}

	private boolean validRC(int dir) {
		switch(dir) {
		case 0: return nRow > 0;
		case 1: return nCol < model.getCurrentLevel().numCols-1;
		case 2: return nRow < model.getCurrentLevel().numRows-1;
		case 3: return nCol > 0;
		}
		return false;
	}
	
	private boolean validRC2(int dir) {
		switch(dir) {
		case 0: return nRow > 1;
		case 1: return nCol < model.getCurrentLevel().numCols-2;
		case 2: return nRow < model.getCurrentLevel().numRows-2;
		case 3: return nCol > 1;
		}
		return false;
	}

}
