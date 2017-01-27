package com.betato.testgame;

import java.awt.Color;
import java.awt.Graphics;

import com.betato.gamedisplay.Frame;
import com.betato.gamedisplay.FrameListener;
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
	boolean fullscreen = true;
	
	public TestGame() {
		Frame frame = new Frame(this, "Title", 300, 300, true, false, false, false);
		start(new GameLoop(60, 120), frame, 2);
	}
	
	@Override
	public void onInit() {
		acc = 100;
		frame.setContentSize(300, 300);
	}

	@Override
	public void onUpdate(InputListener inputListener, FrameListener frameListener) {
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
		if (inputListener.keyUp[90]) {
			frame.setFullscreen(fullscreen);
			fullscreen = !fullscreen;
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
		g.fillOval(200, 200, 8, 8);
	}

	@Override
	public void onExit() {
		System.out.println("exiting");
	}

}
