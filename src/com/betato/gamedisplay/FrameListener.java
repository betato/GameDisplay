package com.betato.gamedisplay;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class FrameListener implements WindowListener, WindowFocusListener, ComponentListener {

	private GameWindow gameWindow;

	/**
	 * If the window has been resized since the last game update.
	 */
	public boolean windowResized = false;
	/**
	 * If the window has been moved since the last game update.
	 */
	public boolean windowMoved = false;

	/**
	 * If the window has gained focus since the last game update.
	 */
	public boolean windowGainedFocus = false;
	/**
	 * If the window has lost focus since the last game update.
	 */
	public boolean windowLostFocus = false;

	/**
	 * If the window has been minimized since the last game update.
	 */
	public boolean windowMinimized = false;
	/**
	 * If the window has been maximized since the last game update.
	 */
	public boolean windowMaximized = false;

	/**
	 * If the window has been set as the active window since the last game
	 * update.
	 */
	public boolean windowActivated = false;
	/**
	 * If the window has lost its status as active window since the last game
	 * update.
	 */
	public boolean windowDeactivated = false;

	/**
	 * If the window has been hidden since the last game update.
	 */
	public boolean windowHidden = false;
	/**
	 * If the window has been shown since the last game update.
	 */
	public boolean windowShown = false;

	/**
	 * If the window has been made visible for the first time since the last
	 * game update.
	 */
	public boolean windowOpened = false;
	/**
	 * If the window has closed since the last game update.
	 */
	public boolean windowClosed = false;
	/**
	 * If the window began closing since the last game update.
	 */
	public boolean windowClosing = false;

	public FrameListener(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public void clear() {
		windowResized = false;
		windowMoved = false;

		windowGainedFocus = false;
		windowLostFocus = false;

		windowMinimized = false;
		windowMaximized = false;

		windowActivated = false;
		windowDeactivated = false;

		windowHidden = false;
		windowShown = false;

		windowOpened = false;
		windowClosed = false;
		windowClosing = false;
	}

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		windowGainedFocus = true;
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		windowLostFocus = false;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		windowActivated = true;
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		windowClosed = true;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		windowClosing = true;
		gameWindow.stop();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		windowDeactivated = false;
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		windowMaximized = false;
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		windowMinimized = true;
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		windowOpened = true;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		windowHidden = true;
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		windowMoved = true;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		windowResized = true;
	}

	@Override
	public void componentShown(ComponentEvent e) {
		windowShown = false;
	}
}
