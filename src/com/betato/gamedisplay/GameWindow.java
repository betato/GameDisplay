package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

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
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		// Render stuff here
		g.dispose();
		bs.show();
	}
	
	@Override
	public void updateFps(int fps, int ups) {
		this.fps = fps;
		this.ups = ups;
	}
}
