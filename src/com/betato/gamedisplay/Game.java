package com.betato.gamedisplay;

import java.awt.Graphics;

/**
 * A game to be run inside a GameWindow with a Frame and GameLoop.
 */
public interface Game {

	/**
	 * Called when GameWindow has initialized, before the game loop starts.
	 * 
	 * @param frame
	 *            A Frame reference to allow editing and resizing of the window
	 */
	public void init(Frame frame);

	/**
	 * Called as specified based on the GameLoop targetUps.
	 * 
	 * @param gameLoop
	 *            The inputListener for this GameWindow, containing mouse and keyboard events that have occurred since
	 *            the last update
	 * @param frameListener
	 *            The frameListener for this GameWindow, containing frame events that have occurred since the last
	 *            update
	 * @param delta
	 *            The amount of time passed since the last update in nanoseconds
	 */
	public void update(InputListener inputListener, FrameListener frameListener, long delta);

	/**
	 * Called as specified based on the GameLoop targetFps.
	 * 
	 * @param g
	 *            The graphics to draw to the GameWindow with.
	 * @param fps
	 *            The current frame rate of the GameWindow.
	 * @param ups
	 *            The current update frequency of the GameWindow.
	 */
	public void render(Graphics g, int fps, int ups);

	/**
	 * Called after the game loop stops when stop is called or when window is closed.
	 */
	public void exit();

	/**
	 * Checks if the game is still running. If false is returned, the game will exit.
	 */
	public boolean running();
}
