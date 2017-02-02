package com.betato.gamedisplay;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private GameWindow gameWindow;
	private int lastWidth;
	private int lastHeight;
	
	public Frame(GameWindow gameWindow, String title, int width, int height, boolean useContentSize, boolean resizable, boolean fullscreen, boolean hideCursor) {
		setup(gameWindow, title, width, height);
		
		if (useContentSize) {
			setContentSize(width, height);
		} else {
			setSize(width, height);
		}
		
		setResizable(resizable);
		if (fullscreen) {
			setUndecorated(true);
			setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}
		if (hideCursor) {
			setCursorHidden(true);
		}
	}
	
	public Frame(GameWindow gameWindow, int width, int height, String title) {
		setup(gameWindow, title, width, height);
		
		setSize(width, height);
		setResizable(false);
	}
	
	private void setup(GameWindow gameWindow, String title, int width, int height) {
		lastWidth = width;
		lastHeight = height;
		
		this.gameWindow = gameWindow;
		add(gameWindow);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(title);
	}
	
	public void setFullscreen(boolean fullscreen) {
		if (isUndecorated() == fullscreen) {
			return;
		}
		// Store size before full screen
		if (fullscreen){
			lastWidth = getWidth();
			lastHeight = getHeight();
		}
		// Dispose window to decorate
		dispose();
		setUndecorated(fullscreen);
		if (fullscreen) {
			// Set window full screen
			setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
			add(gameWindow);
		} else {
			// Set window to defaults
			add(gameWindow);
			setSize(lastWidth, lastHeight);
		}
		// Show window
		setVisible(true);
	}
	
	public void setCursorHidden(boolean hideCursor){ 			
		if (hideCursor) { 			
			// Create a new blank cursor
			BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					cursorImg, new Point(0, 0), "blank cursor"); 			
			// Set the cursor
			getContentPane().setCursor(blankCursor);
		} else {
			// Set default cursor
			getContentPane().setCursor(Cursor.getDefaultCursor());
		}
	}
	
	public void setContentSize(int width, int height) {
		// Set content size and pack
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
	}
}
