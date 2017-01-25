package com.betato.testgame;

import java.awt.Color;
import java.awt.Graphics;

import com.betato.gamedisplay.Frame;
import com.betato.gamedisplay.GameLoop;
import com.betato.gamedisplay.GameWindow;

public class TestGame extends GameWindow{
	private static final long serialVersionUID = 1L;

	int acc;
	
	public TestGame() {
		start(new GameLoop(60, 120), new Frame(300, 300, "Title"));
	}
	
	@Override
	public void onInit() {
		acc = 100;
	}

	@Override
	public void onUpdate(InputListener inputListener) {
		if (acc < 9999){
			acc++;
		} else {
			acc = 0;
		}
	}

	@Override
	public void onRender(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.black);
		g.drawString("fps:" + fps + " ups:" + ups, 10, 10);
		g.drawString("lalala:" + acc, 10, 30);
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

}
