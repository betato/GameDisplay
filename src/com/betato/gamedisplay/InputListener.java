package com.betato.gamedisplay;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayDeque;
import java.util.Queue;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	
	public static final int NUM_KEYS = 526;
	public static final int NUM_BUTTONS = MouseInfo.getNumberOfButtons() + 1;
	
	// Keyboard
	public Queue<KeyEvent> keyPresses = new ArrayDeque<KeyEvent>();
	public boolean[] keyState = new boolean[NUM_KEYS];
	public boolean[] keyDown = new boolean[NUM_KEYS];
	public boolean[] keyUp = new boolean[NUM_KEYS];
	
	// Mouse
	public Queue<MouseEvent> mouseClicks = new ArrayDeque<MouseEvent>();
	public int mouseX;
	public int mouseY;
	public int mouseWheel;
	public boolean[] mouseState = new boolean[NUM_BUTTONS];
	public boolean[] mouseDown = new boolean[NUM_BUTTONS];
	public boolean[] mouseUp = new boolean[NUM_BUTTONS];
	public boolean mouseMoved = false;
	public boolean mouseDragged = false;
	public boolean mouseInsideWindow = true;
	
	public void clear() {
		// Clear keyboard
		keyPresses.clear();
		for (int i = 0; i < NUM_KEYS; i++)
		{
			keyDown[i] = false;
			keyUp[i] = false;
		}
		
		// Clear mouse
		mouseClicks.clear();
		mouseMoved = false;
		mouseDragged = false;
		for (int i = 0; i <NUM_BUTTONS; i++)
		{
			mouseDown[i] = false;
			mouseUp[i] = false;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// Avoid key repeat
		// Set keyDown if key is released
		if (!keyState[e.getKeyCode()]) {
			keyDown[e.getKeyCode()] = true;
			keyState[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyUp[e.getKeyCode()] = true;
		keyState[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPresses.offer(e);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseWheel = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved = true;
		mouseDragged = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseMoved = true;
		mouseDragged = false;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicks.offer(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseInsideWindow = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseInsideWindow = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown[e.getButton()] = true;
		mouseState[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseUp[e.getButton()] = true;
		mouseState[e.getButton()] = false;
	}
}
