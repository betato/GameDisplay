package com.betato.gamedisplay;

public class GameLoop {
	
	private int targetFps = 60;
	private int nanoFps = 1000000000 / targetFps;
	private int targetUps = 60;
	private int nanoUps = 1000000000 / targetUps;
	
	public boolean running = true;
	
	public GameLoop(int targetFps, int targetUps) {
		this.targetFps = targetFps;
		this.targetUps = targetUps;
		nanoFps = 1000000000 / targetFps;
		nanoUps = 1000000000 / targetUps;
	}
	
	// Runs the GameLoop
	public void run() {
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
				
				framecount++;
				deltaFps = 0;
			}

			// Update if target time has been reached
			if (deltaUps >= nanoUps) {
				// Update
				
				updatecount++;
				deltaUps = 0;
			}

			// Update fps and ups if one second has passed
			if (deltaDisplay >= 1000000000) {
				System.out.println("fps:" + framecount + " ups:" + updatecount);
				framecount = 0;
				updatecount = 0;
				deltaDisplay = 0;
			}
		}
	}
}
