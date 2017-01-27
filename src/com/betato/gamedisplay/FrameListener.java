package com.betato.gamedisplay;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class FrameListener implements WindowListener, WindowFocusListener, ComponentListener {
	
	GameWindow gameWindow;
	
	public boolean windowResized = false;
	public boolean windowMoved = false;
	
	public boolean windowGainedFocus = false;
	public boolean windowLostFocus = false;
	
	public boolean windowMinimized = false;
	public boolean windowMaximized = false;
	
	public boolean windowActivated = false;
	public boolean windowDeactivated = false;
	
	public boolean windowHidden = false;
	public boolean windowShown = false;
	
	public boolean windowOpened = false;
	public boolean windowClosed = false;
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
