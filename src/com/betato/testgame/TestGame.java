package com.betato.testgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.betato.gamedisplay.Frame;
import com.betato.gamedisplay.FrameListener;
import com.betato.gamedisplay.Game;
import com.betato.gamedisplay.GameLoop;
import com.betato.gamedisplay.GameWindow;
import com.betato.gamedisplay.InputListener;

public class TestGame implements Game{
	
	public static void main(String[] args) {
		Game game = new TestGame();
		GameLoop loop = new GameLoop(60, 120);
		Frame frame = new Frame("Title", 300, 300);
		
		GameWindow window = new GameWindow(game, loop, frame);
		window.start();
	}
	
	int acc;
	int timesUp = 0;
	int timesDown = 0;
	boolean keyState;
	
	@Override
	public void init() {
		acc = 100;
	}

	@Override
	public void update(InputListener inputListener, FrameListener frameListener, long delta) {
		if (acc < 9999){
			acc++;
		} else {
			acc = 0;
		}
		
		keyState = inputListener.keyState[65];
		if (inputListener.keyUp[KeyEvent.VK_A]) {
			timesUp++;
		}
		if (inputListener.keyDown[KeyEvent.VK_A]) {
			timesDown++;
		}
		for(KeyEvent e : inputListener.keyPresses) { 
			  System.out.println(e.getKeyChar()); 
		}
		for(MouseEvent e : inputListener.mouseClicks) { 
			  System.out.println(e.getButton()); 
		}
	}

	@Override
	public void render(Graphics g, int fps, int ups) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.black);
		g.drawString("fps:" + fps + " ups:" + ups, 10, 10);
		g.drawString("lalala:" + acc, 10, 30);
		g.drawString("state:" + keyState + " up:" + timesUp + " Down: " + timesDown, 10, 50);
		g.fillOval(200, 200, 8, 8);
	}

	@Override
	public void exit() {
		System.out.println("exiting");
	}

	@Override
	public boolean running() {
		return true;
	}

}
