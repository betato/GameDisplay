package com.betato.testgame;

import java.awt.Color;
import java.awt.Graphics;

import com.betato.gamedisplay.Frame;
import com.betato.gamedisplay.GameLoop;
import com.betato.gamedisplay.GameWindow;
import com.betato.gamedisplay.InputListener;

public class TestGame extends GameWindow{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new TestGame();
	}
	
	int acc;
	int timesUp = 0;
	int timesDown = 0;
	boolean keyState;
	
	public TestGame() {
		start(new GameLoop(60, 120), new Frame(300, 300, "Title", false, false));
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
		
		keyState = inputListener.keyState[65];
		if (inputListener.keyUp[65]) {
			timesUp++;
		}
		if (inputListener.keyDown[65]) {
			timesDown++;
		}
	}

	@Override
	public void onRender(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.black);
		g.drawString("fps:" + fps + " ups:" + ups, 10, 10);
		g.drawString("lalala:" + acc, 10, 30);
		g.drawString("state:" + keyState + " up:" + timesUp + " Down: " + timesDown, 10, 50);
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

}
