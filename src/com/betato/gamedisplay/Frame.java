package com.betato.gamedisplay;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	public Frame(int width, int height, String title, boolean resizable, boolean fullscreen, boolean hideCursor) {
		this.width = width;
		this.height = height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		
		setSize(width, height);
		setResizable(resizable);
		if (fullscreen) {
			setUndecorated(true);
			setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}
		if (hideCursor) {
			hideCursor(true);
		}
	}
	
	public void createFrame(GameWindow gameWindow) {
		add(gameWindow);
		setVisible(true);
	}
	
	public void hideCursor(boolean hideCursor){ 			
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
	
	public void setWindowSize(int width, int height) {
		// Update default size
		this.width = width;
		this.height = height;
		// Resize window
		setSize(width, height);
	}
	
	public void setContentSize(int width, int height) {
		// Set content size and pack
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
		// Update default size
		width = getWidth();
		height = getHeight();
	}
}
