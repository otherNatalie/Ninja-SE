package nijase.controller;

import nijase.model.Model;
import nijase.view.Application;

public class ResetController {
	Application app;
	Model model;
	
	public ResetController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void process() {
		//told to do something
		model.setCurrentLevel(model.getLvlNum());
		model.resetMoveCount();
		app.getMoveCounter().setText(model.getMoveCount() + " moves");
		app.getWinSign().setText("");
		//refresh everything
		app.repaint();
	}
}
