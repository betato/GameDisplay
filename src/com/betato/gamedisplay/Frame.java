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
	
	public Frame(GameWindow gameWindow, String title, int width, int height, boolean useContentSize, boolean resizable, boolean fullscreen, boolean hideCursor) {
		setup(gameWindow, title);
		
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
		setup(gameWindow, title);
		
		setSize(width, height);
		setResizable(false);
	}
	
	private void setup(GameWindow gameWindow, String title) {
		this.gameWindow = gameWindow;
		add(gameWindow);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
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
