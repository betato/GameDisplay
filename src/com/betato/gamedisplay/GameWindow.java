package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class GameWindow extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	private InputListener inputListener;
	private FrameListener frameListener;
	private int frameBuffers = 2;
	
	public Frame frame;
	public int fps, ups = 0;
	
	public void start(GameLoop gameLoop, Frame frame, int frameBuffers) {
		this.frameBuffers = frameBuffers;
		start(gameLoop, frame);
	}
	
	public void start(GameLoop gameLoop, Frame frame) {
		this.gameLoop = gameLoop;
		this.frame = frame;
		
		inputListener = new InputListener();
		frameListener = new FrameListener(this);
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		addMouseMotionListener(inputListener);
		addMouseWheelListener(inputListener);
		frame.addWindowListener(frameListener);
		frame.addWindowFocusListener(frameListener);
		frame.addComponentListener(frameListener);
		
		frame.setVisible(true);
		onInit();
		gameLoop.run(this);
	}
	
	public void stop() {
		gameLoop.running = false;
		onExit();
		System.exit(0);
	}
	
	public void update() {
		onUpdate(inputListener, frameListener, gameLoop.deltaUps);
		inputListener.clear();
		frameListener.clear();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(frameBuffers);
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
	abstract public void onUpdate(InputListener inputListener, FrameListener frameListener, long delta);

	// Called on render
	abstract public void onRender(Graphics g);

	// Called on GameWindow exit
	abstract public void onExit();
}
