package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class GameWindow extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	private InputListener inputListener;
	
	public int fps, ups = 0;
	
	public void start(GameLoop gameLoop, Frame frame) {
		frame.createFrame(this);
		this.gameLoop = gameLoop;
		
		inputListener = new InputListener();
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		addMouseMotionListener(inputListener);
		addMouseWheelListener(inputListener);
		
		gameLoop.run(this);
	}
	
	public void stop() {
		gameLoop.running = false;
		onExit();
	}
	
	public void init() {
		onInit();
	}
	
	public void update() {
		onUpdate();
	}
	
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
