package com.betato.gamedisplay;

public interface Game {
	// Called once when GameLoop begins
	public void init();

	// Called n times per second depending on target ups
	public void update();

	// Called n times per second depending on target fps
	public void render();
	
	// Called once per second to update fps and ups
	public void updateFps(int fps, int ups);
}
