package com.betato.testgame;

import com.betato.gamedisplay.GameLoop;

public class Main {
	public static void main(String[] args) {
		GameLoop loop;
		loop = new GameLoop(60, 60);
		loop.run();
	}
}
