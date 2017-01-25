package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public abstract class GameWindow extends Canvas implements Game {
	
	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	protected JFrame frame;
	
	public int fps, ups = 0;
	
	public void start(GameLoop gameLoop, Frame frame) {
		frame.createFrame(this);
		this.gameLoop = gameLoop;
		gameLoop.run(this);
	}
	
	public void stop() {
		gameLoop.running = false;
		onExit();
	}
	
	@Override
	public void init() {
		onInit();
	}
	
	@Override
	public void update() {
		onUpdate();
	}
	
	@Override
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		onRender(g);
		g.dispose();
		bs.show();
	}
	
	@Override
	public void updateFps(int fps, int ups) {
		this.fps = fps;
		this.ups = ups;
	}
	
	// Called on initialization
	abstract public void onInit();

	// Called on update
	abstract public void onUpdate(/* Add mouse and keyboard inputs */);

	// Called on render
	abstract public void onRender(Graphics g);

	// Called on GameWindow exit
	abstract public void onExit();
}
