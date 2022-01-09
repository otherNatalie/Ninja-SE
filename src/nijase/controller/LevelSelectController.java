package nijase.controller;

import nijase.model.Model;
import nijase.view.Application;

public class LevelSelectController {
	Application app;
	Model model;
	int level;
	
	public LevelSelectController(Application app, Model model, int level) {
		this.app = app;
		this.model = model;
		this.level = level;
	}
	
	public void process() {
		//model.setLvlNum(level);
		model.setCurrentLevel(level);
		model.resetMoveCount();
		app.getMoveCounter().setText(model.getMoveCount() + " moves");
		//told to do something
		app.getWinSign().setText("");
		app.repaint();
	}
}
