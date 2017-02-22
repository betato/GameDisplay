package com.betato.gamedisplay;

/**
 * A game loop to run a GameWindow at the specified frame and update rate.
 */
public class GameLoop {

	private int targetFps = 60;
	private int nanoFps = 1000000000 / targetFps;
	private int targetUps = 60;
	private int nanoUps = 1000000000 / targetUps;

	private boolean running = true;

	/**
	 * Creates a new GameLoop with the specified frame rate and update rate.
	 * 
	 * @param targetFps
	 *            The frame rate for the GameWindow in frames per second
	 * @param targetUps
	 *            The update rate for the GameWindow in updates per second
	 */
	public GameLoop(int targetFps, int targetUps) {
		this.targetFps = targetFps;
		this.targetUps = targetUps;
		nanoFps = 1000000000 / targetFps;
		nanoUps = 1000000000 / targetUps;
	}

	protected void run(GameWindow game) {

		long startTime = System.nanoTime();
		long deltaFps = 0;
		long deltaUps = 0;
		long deltaDisplay = 0;
		int framecount = 0;
		int updatecount = 0;

		while (running) {
			// Get current time
			long currentTime = System.nanoTime();
			// Get time since last loop
			deltaFps += currentTime - startTime;
			deltaUps += currentTime - startTime;
			deltaDisplay += currentTime - startTime;

			// Set start time of this loop for use in next cycle
			startTime = currentTime;

			// Render if target time has been reached
			if (deltaFps >= nanoFps) {
				// Render
				game.render();
				framecount++;
				deltaFps = 0;
			}

			// Update if target time has been reached
			if (deltaUps >= nanoUps) {
				// Update
				game.update(deltaUps);
				updatecount++;
				deltaUps = 0;
			}

			// Update fps and ups if one second has passed
			if (deltaDisplay >= 1000000000) {
				game.updateFps(framecount, updatecount);
				framecount = 0;
				updatecount = 0;
				deltaDisplay = 0;
			}
		}
	}
	
	protected void stop() {
		running = false;
	}
}
