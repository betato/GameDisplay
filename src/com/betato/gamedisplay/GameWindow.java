package com.betato.gamedisplay;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * A window for a game to be run.
 */
public class GameWindow extends Canvas {

	private static final long serialVersionUID = 1L;
	private GameLoop gameLoop;
	private InputListener inputListener;
	private FrameListener frameListener;
	private int frameBuffers;

	/**
	 * The game to be run.
	 */
	public Game game;

	/**
	 * The frame which contains this GameWindow.
	 */
	public Frame frame;

	/**
	 * The current frame rate and update rate, updated once per second.
	 */
	public int fps, ups = 0;

	/**
	 * Creates a new GameLoop and initializes listeners.
	 * 
	 * @param game
	 *            The game to be run
	 * @param gameLoop
	 *            The gameLoop to use with this GameWindow
	 * @param frame
	 *            The frame to hold this GameWindow
	 * @param frameBuffers
	 *            The amount of frame buffers to use for rendering
	 */
	public GameWindow(Game game, GameLoop gameLoop, Frame frame, int frameBuffers) {
		this.game = game;
		this.gameLoop = gameLoop;
		this.frame = frame;
		this.frameBuffers = frameBuffers;
		
		inputListener = new InputListener();
		frameListener = new FrameListener(this);
		
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		addMouseMotionListener(inputListener);
		addMouseWheelListener(inputListener);
		
		frame.addWindowListener(frameListener);
		frame.addWindowFocusListener(frameListener);
		frame.addComponentListener(frameListener);
		
		game.init();
	}

	/**
	 * Creates a new GameLoop and initializes listeners.
	 * 
	 * @param game
	 *            The game to be run
	 * @param gameLoop
	 *            The gameLoop to use with this GameWindow
	 * @param frame
	 *            The frame to hold this GameWindow
	 */
	public GameWindow(Game game, GameLoop gameLoop, Frame frame) {
		this(game, gameLoop, frame, 2);
	}
	
	/**
	 * Shows window and starts gameLoop.
	 */
	public void start() {
		frame.setVisible(true);
		gameLoop.run(this);
	}

	/**
	 * Stops the GameLoop and exits the program. Closing the window will do this automatically.
	 */
	public void stop() {
		gameLoop.stop();
		game.exit();
		System.exit(0);
	}

	protected void update(long deltaUps) {
		game.update(inputListener, frameListener, deltaUps);
		inputListener.clear();
		frameListener.clear();
	}

	protected void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(frameBuffers);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		game.render(g);
		g.dispose();
		bs.show();
	}

	protected void updateFps(int fps, int ups) {
		this.fps = fps;
		this.ups = ups;
	}
}
