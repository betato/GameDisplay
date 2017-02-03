package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * A window for a game
 */
public abstract class GameWindow extends Canvas {

	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	private InputListener inputListener;
	private FrameListener frameListener;
	private int frameBuffers = 2;

	/**
	 * The frame which contains this GameWindow.
	 */
	public Frame frame;

	/**
	 * The current frame rate and update rate, updated once per second.
	 */
	public int fps, ups = 0;

	/**
	 * Initializes listeners and starts GameLoop.
	 * 
	 * @param gameLoop
	 *            The gameLoop to use with this GameWindow
	 * @param frame
	 *            The frame to hold this GameWindow
	 * @param frameBuffers
	 *            The amount of frame buffers to use for rendering
	 */
	public void start(GameLoop gameLoop, Frame frame, int frameBuffers) {
		this.frameBuffers = frameBuffers;
		start(gameLoop, frame);
	}

	/**
	 * Initializes listeners and starts GameLoop.
	 * 
	 * @param gameLoop
	 *            The gameLoop to use with this GameWindow
	 * @param frame
	 *            The frame to hold this GameWindow
	 */
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

	/**
	 * Stops the GameLoop and exits the program. Closing the window calls this
	 * method.
	 */
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

	/**
	 * Called when GameWindow has initialized, before the game loop starts.
	 */
	abstract public void onInit();

	/**
	 * Called as specified based on the GameLoop targetUps.
	 * 
	 * @param gameLoop
	 *            The inputListener for this GameWindow, containing mouse and
	 *            keyboard events that have occurred since the last update
	 * @param frameListener
	 *            The frameListener for this GameWindow, containing frame events
	 *            that have occurred since the last update
	 * @param delta
	 *            The amount of time passed since the last update in nanoseconds
	 */
	abstract public void onUpdate(InputListener inputListener, FrameListener frameListener, long delta);

	/**
	 * Called as specified based on the GameLoop targetFps.
	 * 
	 * @param g
	 *            The graphics to draw to the GameWindow with.
	 */
	abstract public void onRender(Graphics g);

	/**
	 * Called after the game loop stops when stop is called or when window is
	 * closed.
	 */
	abstract public void onExit();
}
