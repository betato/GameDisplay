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
	
	public static final int NUM_KEYS = 223;
	public static final int NUM_BUTTONS = MouseInfo.getNumberOfButtons();
	
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
	
	// Index of keycodes
	public static final int START_NUMROW = 48;
	public static final int END_NUMROW = 57;
	public static final int START_LETTERS = 65;
	public static final int END_LETTERS = 90;
	public static final int START_NUMPAD = 96;
	public static final int END_NUMPAD = 111;
	public static final int START_SYMBOLDS = 186;
	public static final int END_SYMBOLS = 222;
	
	public static final int COMMA = 44;
	public static final int DASH = 45;
	public static final int PERIOD = 46;
	public static final int SLASH = 47;
	public static final int SEMICOLON = 59;
	public static final int EQUALS = 61;
	public static final int BRACKET_OPEN = 91;
	public static final int BACKSLASH = 92;
	public static final int BRACKET_CLOSE = 93;
	
	// All other keys
	public static final int BACKSPACE = 8;
	public static final int TAB = 9;
	public static final int ENTER = 13;
	public static final int SHIFT = 16;
	public static final int CTRL = 17;
	public static final int ALT = 18;
	public static final int PAUSE_BREAK = 19;
	public static final int LOCK_CAPS = 20;
	public static final int ESCAPE = 27;
	public static final int SPACE = 32;
	public static final int PAGE_UP = 33;
	public static final int PAGE_DOWN = 34;
	public static final int END = 35;
	public static final int HOME = 36;
	public static final int ARROW_LEFT = 37;
	public static final int ARROW_UP = 38;
	public static final int ARROW_RIGHT = 39;
	public static final int ARROW_DOWN = 40;
	public static final int INSERT = 45;
	public static final int DELETE = 46;
	public static final int NUMROW_0 = 48;
	public static final int NUMROW_1 = 49;
	public static final int NUMROW_2 = 50;
	public static final int NUMROW_3 = 51;
	public static final int NUMROW_4 = 52;
	public static final int NUMROW_5 = 53;
	public static final int NUMROW_6 = 54;
	public static final int NUMROW_7 = 55;
	public static final int NUMROW_8 = 56;
	public static final int NUMROW_9 = 57;
	public static final int A = 65;
	public static final int B = 66;
	public static final int C = 67;
	public static final int D = 68;
	public static final int E = 69;
	public static final int F = 70;
	public static final int G = 71;
	public static final int H = 72;
	public static final int I = 73;
	public static final int J = 74;
	public static final int K = 75;
	public static final int L = 76;
	public static final int M = 77;
	public static final int N = 78;
	public static final int O = 79;
	public static final int P = 80;
	public static final int Q = 81;
	public static final int R = 82;
	public static final int S = 83;
	public static final int T = 84;
	public static final int U = 85;
	public static final int V = 86;
	public static final int W = 87;
	public static final int X = 88;
	public static final int Y = 89;
	public static final int Z = 90;
	public static final int WINDOWS_KEY_LEFT = 91;
	public static final int WINDOWS_KEY_RIGHT = 92;
	public static final int SELECT_KEY = 93;
	public static final int NUMPAD_0 = 96;
	public static final int NUMPAD_1 = 97;
	public static final int NUMPAD_2 = 98;
	public static final int NUMPAD_3 = 99;
	public static final int NUMPAD_4 = 100;
	public static final int NUMPAD_5 = 101;
	public static final int NUMPAD_6 = 102;
	public static final int NUMPAD_7 = 103;
	public static final int NUMPAD_8 = 104;
	public static final int NUMPAD_9 = 105;
	public static final int MULTIPLY = 106;
	public static final int ADD = 107;
	public static final int SUBTRACT = 109;
	public static final int DECIMAL_POINT = 110;
	public static final int DIVIDE = 111;
	public static final int F1 = 112;
	public static final int F2 = 113;
	public static final int F3 = 114;
	public static final int F4 = 115;
	public static final int F5 = 116;
	public static final int F6 = 117;
	public static final int F7 = 118;
	public static final int F8 = 119;
	public static final int F9 = 120;
	public static final int F10 = 121;
	public static final int F11 = 122;
	public static final int F12 = 123;
	public static final int LOCK_NUM = 144;
	public static final int LOCK_SCROLL = 145;
	public static final int FORWARD_SLASH = 191;
	public static final int GRAVE_ACCENT = 192;
	public static final int BRAKET_CLOSE = 221;
	public static final int SINGLE_QUOTE = 222;
	
	// Alternate keys
	public static final int SEMICOLON_A = 186;
	public static final int EQUALS_A = 187;
	public static final int COMMA_A = 188;
	public static final int DASH_A = 189;
	public static final int PERIOD_A = 190;
	public static final int BRACKET_OPEN_A = 219;
	public static final int BACKSLASH_A = 220;
}
