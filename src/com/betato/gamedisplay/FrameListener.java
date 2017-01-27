package com.betato.gamedisplay;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class FrameListener implements WindowListener, WindowFocusListener {
	
	public boolean windowFocused = true;
	public boolean windowClosing = false;
	public boolean windowClosed = false;
	public boolean windowMinimized = false;
	public boolean windowActive = true;
	
	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		windowFocused = true;
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		windowFocused = false;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		windowActive = true;
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		windowClosed = true;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		windowClosing = true;
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		windowActive = false;
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		windowMinimized = false;
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		windowMinimized = true;
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		windowFocused = true;
	}
}
