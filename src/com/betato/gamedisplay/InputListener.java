package com.betato.gamedisplay;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	/**
	 * The amount of possible key values.
	 */
	public static final int NUM_KEYS = 526;
	/**
	 * The amount of possible button values.
	 */
	public static final int NUM_BUTTONS = MouseInfo.getNumberOfButtons() + 1;

	// Keyboard
	/**
	 * A list of keyTyped events that have occurred since the last game update.
	 */
	public Queue<KeyEvent> keyPresses = new ConcurrentLinkedQueue<KeyEvent>();
	/**
	 * Current depressed/released state of all possible key values.
	 */
	public boolean[] keyState = new boolean[NUM_KEYS];
	/**
	 * If keys have been depressed since the last game update.
	 */
	public boolean[] keyDown = new boolean[NUM_KEYS];
	/**
	 * If keys have been released since the last game update.
	 */
	public boolean[] keyUp = new boolean[NUM_KEYS];

	// Mouse
	/**
	 * A list of mouseClicked events that have occurred since the last game update.
	 */
	public Queue<MouseEvent> mouseClicks = new ConcurrentLinkedQueue<MouseEvent>();
	/**
	 * The current x axis position of the mouse in pixels from the top left corner of the GameWindow.
	 */
	public int mouseX;
	/**
	 * The current y axis position of the mouse in pixels from the top left corner of the GameWindow.
	 */
	public int mouseY;
	/**
	 * The current position of mouse wheel.
	 */
	public int mouseWheel;
	/**
	 * Current depressed/released state of all possible mouse buttons.
	 */
	public boolean[] mouseState = new boolean[NUM_BUTTONS];
	/**
	 * If mouse buttons been depressed since the last game update.
	 */
	public boolean[] mouseDown = new boolean[NUM_BUTTONS];
	/**
	 * If mouse buttons have been released since the last game update.
	 */
	public boolean[] mouseUp = new boolean[NUM_BUTTONS];
	/**
	 * If the mouse has moved since the last game update.
	 */
	public boolean mouseMoved = false;
	/**
	 * If the mouse has been dragged (moved while clicked) since the last game update.
	 */
	public boolean mouseDragged = false;
	/**
	 * If the mouse is currently inside the GameWindow.
	 */
	public boolean mouseInsideWindow = true;

	public void clear() {
		// Clear keyboard
		keyPresses.clear();
		for (int i = 0; i < NUM_KEYS; i++) {
			keyDown[i] = false;
			keyUp[i] = false;
		}

		// Clear mouse
		mouseClicks.clear();
		mouseMoved = false;
		mouseDragged = false;
		for (int i = 0; i < NUM_BUTTONS; i++) {
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
