package com.betato.gamedisplay;

import java.awt.Canvas;

public abstract class GameWindow extends Canvas implements Game {

	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	
	public GameWindow(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
		gameLoop.run(this);
	}
}
