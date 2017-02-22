package com.betato.gamedisplay;

import java.awt.Graphics;

/**
 * A game to be run inside a GameWindow with a Frame and GameLoop.
 */
public interface Game {
	
	/**
	 * Called when GameWindow has initialized, before the game loop starts.
	 */
	public void init();

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
	 */
	public void render(Graphics g);

	/**
	 * Called after the game loop stops when stop is called or when window is closed.
	 */
	public void exit();
}
