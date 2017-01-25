package com.betato.testgame;

import java.awt.Graphics;

import com.betato.gamedisplay.Frame;
import com.betato.gamedisplay.GameLoop;
import com.betato.gamedisplay.GameWindow;

public class TestGame extends GameWindow{
	private static final long serialVersionUID = 1L;

	public TestGame() {
		start(new GameLoop(60, 120), new Frame(300, 300, "Title"));
	}
	
	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRender(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

}
