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

	private int fps = 0; 
	private int ups = 0;
	
	/**
	 * The game to be run.
	 */
	public Game game;

	/**
	 * The frame which contains this GameWindow.
	 */
	public Frame frame;


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
		
		frame.add(this);
		
		inputListener = new InputListener();
		frameListener = new FrameListener(this);
		
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		addMouseMotionListener(inputListener);
		addMouseWheelListener(inputListener);
		
		frame.addWindowListener(frameListener);
		frame.addWindowFocusListener(frameListener);
		frame.addComponentListener(frameListener);
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
		game.init(frame);
		gameLoop.run(this);
	}

	/**
	 * Stops the GameLoop and exits the program. Closing the window or returning false for Game.running() will do this automatically.
	 */
	public void stop() {
		gameLoop.stop();
		game.exit();
		System.exit(0);
	}

	protected void update(long deltaUps) {
		if (game.running()) {
			game.update(inputListener, frameListener, deltaUps);
			inputListener.clear();
			frameListener.clear();
		} else {
			stop();
		}
	}

	protected void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(frameBuffers);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		game.render(g, fps, ups);
		g.dispose();
		bs.show();
	}

	protected void updateFps(int fps, int ups) {
		this.fps = fps;
		this.ups = ups;
	}
}
