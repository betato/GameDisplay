package com.betato.gamedisplay;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
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
	}
	
	public void createFrame(GameWindow gameWindow) {
		add(gameWindow);
		setVisible(true);
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
