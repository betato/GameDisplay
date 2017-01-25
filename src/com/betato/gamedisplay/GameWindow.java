package com.betato.gamedisplay;

import java.awt.Canvas;

public abstract class GameWindow extends Canvas implements Game {
	
	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	
	public int fps, ups = 0;
	
	public GameWindow(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
		gameLoop.run(this);
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void render() {
		
	}
	
	@Override
	public void updateFps(int fps, int ups) {
		this.fps = fps;
		this.ups = ups;
	}
}
